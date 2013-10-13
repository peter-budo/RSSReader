package com.petermiklosko.rssreader;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.ListView;

public class RSSActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Result> {

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
    }

    @Override
    public Loader<Result> onCreateLoader(int i, Bundle bundle) {
        return new FeedLoader(getApplicationContext());
    }

    @Override
    public void onLoadFinished(Loader<Result> resultLoader, Result result) {

    }

    @Override
    public void onLoaderReset(Loader<Result> resultLoader) {

    }
}