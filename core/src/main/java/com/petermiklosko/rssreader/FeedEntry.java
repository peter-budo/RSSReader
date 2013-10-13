package com.petermiklosko.rssreader;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item")
public class FeedEntry extends RSSItem{

    @Element(name = "description", required = false)
    private String description;
    @Element(name = "trackName")
    private String trackName;
    @Element(name = "trackArtist")
    private String trackArtist;
    @Element(name = "trackId")
    private long trackId;
    @Element(name = "guid")
    private String guid;
    @Element(name = "pubDate")
    private String pubDate;

    public String getDescription() {
        return description;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public long getTrackId() {
        return trackId;
    }

    public String getPubDate() {
        return pubDate;
    }
}
