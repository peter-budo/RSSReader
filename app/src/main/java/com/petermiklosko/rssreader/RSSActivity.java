package com.petermiklosko.rssreader;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.ListView;

import com.petermiklosko.rssreader.connection.Result;

import java.util.ArrayList;
import java.util.List;

public class RSSActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Result> {

    private static final int ID_LOADER = 100;
    private static final String SHAZAM_RSS = "feed://www.shazam.com/music/web/taglistrss?mode=xml&userName=shazam";

    private ListView feedsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_activity);
        feedsListView = (ListView) findViewById(R.id.feeds_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().initLoader(ID_LOADER, null, this);
    }

    @Override
    public Loader<Result> onCreateLoader(int i, Bundle bundle) {
        return new FeedLoader(getApplicationContext(), SHAZAM_RSS);
    }

    @Override
    public void onLoadFinished(Loader<Result> resultLoader, Result result) {
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
        feedItems.add(rssRoot.getFeed().getFeedImage());
        feedItems.addAll(rssRoot.getFeed().getFeedList());
    }

    private void handleError(String message) {

    }
}