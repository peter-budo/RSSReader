package com.petermiklosko.rssreader;

import org.simpleframework.xml.Element;

public class RSSItem {

    @Element(name = "title")
    private String title;
    @Element(name = "link")
    private String link;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
