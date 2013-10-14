package com.petermiklosko.rssreader;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.*;

import com.novoda.imageloader.core.ImageManager;
import com.novoda.imageloader.core.LoaderSettings;
import com.novoda.imageloader.core.cache.LruBitmapCache;
import com.petermiklosko.rssreader.connection.Result;
import com.petermiklosko.rssreader.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class RSSActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Result>, AdapterView.OnItemClickListener {

    private static final int ID_LOADER = 100;
    private static final String SHAZAM_RSS = "feed://www.shazam.com/music/web/taglistrss?mode=xml&userName=shazam";
    private static final String FEED_PROTOCOL = "feed://";
    private static final String HTTP_PROTOCOL = "http://";
    private static final int BLUE = 0xFF6ea6df;

    private ListView feedsListView;
    private ProgressBar progressBar;
    private FeedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_activity);
        feedsListView = (ListView) findViewById(R.id.feeds_list);
        feedsListView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.empty_view_progress_bar);
        progressBar.getIndeterminateDrawable().setColorFilter(BLUE, android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().initLoader(ID_LOADER, null, this);
    }

    @Override
    public Loader<Result> onCreateLoader(int i, Bundle bundle) {
        return new FeedLoader(getApplicationContext(), getURL(SHAZAM_RSS));
    }

    @Override
    public void onLoadFinished(Loader<Result> resultLoader, Result result) {
        progressBar.setVisibility(View.GONE);
        if(result == Result.SUCCESS) {
            handleSuccess(result.getFeeds());
        } else {
            handleError(result.getMessage());
        }
    }

    @Override
    public void onLoaderReset(Loader<Result> resultLoader) {
    }

    private void handleSuccess(RSSRoot rssRoot) {
        List<FeedItem> feedItems = new ArrayList<FeedItem>();
        listHeader(rssRoot.getFeed().getFeedImage());
        feedItems.addAll(rssRoot.getFeed().getFeedList());
        adapter = new FeedAdapter(getApplicationContext(), feedItems);
        feedsListView.setAdapter(adapter);
    }

    private void handleError(String message) {
        TextView errorMessage = (TextView) findViewById(R.id.error_message);
        errorMessage.setText(message);
        errorMessage.setVisibility(View.VISIBLE);
    }

    private String getURL(String url) {
        if(url.startsWith(FEED_PROTOCOL)){
            return url.replace(FEED_PROTOCOL, HTTP_PROTOCOL);
        }
        return url;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(((FeedEntry) adapter.getItem(position)).getLink()));
        startActivity(intent);
    }

    private void listHeader(FeedImage feedImage) {
        TextView header = (TextView) findViewById(R.id.header_title);
        header.setText(feedImage.getTitle());
        ImageView headerImage = (ImageView) findViewById(R.id.header_image);
        ImageLoader imageLoader = provideImageLoader();
        imageLoader.loadImage(headerImage, feedImage.getUrl());
    }

    protected ImageLoader provideImageLoader() {
        LoaderSettings settings = new LoaderSettings.SettingsBuilder()
                .withDisconnectOnEveryCall(true)
                .withCacheManager(new LruBitmapCache(getApplicationContext()))
                .build(getApplicationContext());
        return new ImageLoader(new ImageManager(getApplicationContext(), settings));
    }
}