package com.petermiklosko.rssreader;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name ="rss", strict = false )
public class RSSRoot {
    @Element(name="channel")
    private RSSFeed feed;

    public RSSFeed getFeed() {
        return feed;
    }
}
