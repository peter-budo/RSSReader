package com.petermiklosko.rssreader.connection;

import com.petermiklosko.rssreader.RSSRoot;

public enum Result {
    SUCCESS, FAILURE, ERROR, NETWORK_FAILURE("network error"), CANCELLED("cancelled");

    private String message = "";
    private RSSRoot feeds;

    private Result(String message) {
        this.message = message;
    }

    private Result() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public RSSRoot getFeeds() {
        return feeds;
    }

    public void setFeeds(RSSRoot feeds) {
        this.feeds = feeds;
    }
}
