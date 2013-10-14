package com.petermiklosko.rssreader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.github.kevinsawicki.http.HttpRequest;
import com.petermiklosko.rssreader.connection.Failure;
import com.petermiklosko.rssreader.connection.RSSRequest;
import com.petermiklosko.rssreader.connection.Result;

public class FeedLoader extends AsyncTaskLoader<Result> {

    private final String url;

    public FeedLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Result loadInBackground() {
        try {
            RSSRequest request = new RSSRequest(url);
            RSSRoot rssRoot = request.execute();
            return actOn(rssRoot);
        } catch (Failure f) {
            if (f.getCause() instanceof HttpRequest.HttpRequestException) {
                return Result.NETWORK_FAILURE;
            }
            return Result.FAILURE;
        }
    }

    private Result actOn(RSSRoot rssRoot) {
        if (rssRoot != null) {
            Result r = Result.SUCCESS;
            r.setFeeds(rssRoot);
            return r;
        } else {
            Result result = Result.FAILURE;
            return result;
        }
    }
}
