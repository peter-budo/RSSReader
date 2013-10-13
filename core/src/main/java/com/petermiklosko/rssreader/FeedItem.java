package com.petermiklosko.rssreader;

import org.simpleframework.xml.Element;

public class FeedItem {
    @Element
    private final String title;
    private final String link;

    public FeedItem(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
