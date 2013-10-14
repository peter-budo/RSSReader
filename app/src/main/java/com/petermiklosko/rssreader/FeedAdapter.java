package com.petermiklosko.rssreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.feed_item, parent, false);
        FeedEntry feedEntry = (FeedEntry) getItem(position);
        TextView trackName = (TextView) view.findViewById(R.id.track_name);
        trackName.setText(feedEntry.getTrackName());
        TextView trackArtist = (TextView) view.findViewById(R.id.track_artist);
        trackArtist.setText(feedEntry.getTrackArtist());
        TextView publishDate = (TextView) view.findViewById(R.id.publish_date);
        publishDate.setText(feedEntry.getPubDate());
        return view;
    }
}
