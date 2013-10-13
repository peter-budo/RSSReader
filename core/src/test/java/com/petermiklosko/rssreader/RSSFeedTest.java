package com.petermiklosko.rssreader;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class RSSFeedTest {

    @Test
    public void shouldParseFeed() throws Exception {
        Serializer serializer = new Persister();
        RSSRoot rssRoot = serializer.read(RSSRoot.class, getClass().getResourceAsStream("/feed.xml"));
        assertNotNull(rssRoot);
        assertEquals("Expected 29 feed entries", 29, rssRoot.getFeed().getFeedList().size());
    }
}
