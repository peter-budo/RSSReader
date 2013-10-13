package com.petermiklosko.rssreader;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ListView;

public class RSSActivity extends FragmentActivity {

    private ListView feedsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_activity);
        feedsListView = (ListView) findViewById(R.id.feeds_list);
    }
}