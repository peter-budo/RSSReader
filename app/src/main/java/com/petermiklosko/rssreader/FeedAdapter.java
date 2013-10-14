package com.petermiklosko.rssreader;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class FeedAdapter extends BaseAdapter{

    private final Context context;
    private final List<FeedItem> feedItems;

    public FeedAdapter(Context context, List<FeedItem> fedItems) {
        this.context = context;
        this.feedItems = fedItems;
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int position) {
        return feedItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
