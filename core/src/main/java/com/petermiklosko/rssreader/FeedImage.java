package com.petermiklosko.rssreader;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "image", strict = false)
public class FeedImage {
    @Element(name = "title")
    private String title;
    @Element(name = "url")
    private String url;
    @Element(name = "link")
    private String link;


    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return url;
    }

    public String getLinkUrl() {
        return link;
    }
}
