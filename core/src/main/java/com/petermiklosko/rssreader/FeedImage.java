package com.petermiklosko.rssreader;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "image", strict = false)
public class FeedImage extends RSSItem {

    @Element(name = "url")
    private String url;

    public String getUrl() {
        return url;
    }
}
