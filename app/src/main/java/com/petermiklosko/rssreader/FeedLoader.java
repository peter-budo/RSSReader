package com.petermiklosko.rssreader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class FeedLoader extends AsyncTaskLoader<Result> {

    public FeedLoader(Context context) {
        super(context);
    }

    @Override
    public Result loadInBackground() {
        return null;
    }
}
