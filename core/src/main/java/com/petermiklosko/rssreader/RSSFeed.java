package com.petermiklosko.rssreader;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="channel")
public class RSSFeed extends RSSItem {
    @Element(name = "description")
    private String description;
    @Element(name = "language")
    private String language;
    @Element(name = "lastBuildDate")
    private String buildDate;
    @Element(name = "copyright")
    private String copyright;
    @Element(name = "docs")
    private String docs;
    @Element(name = "ttl")
    private int ttl;
    @Element(name = "image")
    private FeedImage feedImage;
    @ElementList(inline=true)
    private List<FeedEntry> feedList;

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDocs() {
        return docs;
    }

    public int getTtl() {
        return ttl;
    }

    public FeedImage getFeedImage() {
        return feedImage;
    }

    public List<FeedEntry> getFeedList() {
        return feedList;
    }
}
