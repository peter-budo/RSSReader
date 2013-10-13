package com.petermiklosko.rssreader;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item")
public class FeedEntry {

    @Element(name = "title")
    private String title;
    @Element(name = "description", required = false)
    private String description;
    @Element(name = "trackName")
    private String trackName;
    @Element(name = "trackArtist")
    private String trackArtist;
    @Element(name = "trackId")
    private long trackId;
    @Element(name = "link")
    private String link;
    @Element(name = "guid")
    private String guid;
    @Element(name = "pubDate")
    private String pubDate;

    public String getTitle() {
        return title;
    }

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

    public String getLink() {
        return link;
    }

    public String getPubDate() {
        return pubDate;
    }
}
