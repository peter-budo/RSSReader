package com.petermiklosko.rssreader.connection;

import com.github.kevinsawicki.http.HttpRequest;
import com.petermiklosko.rssreader.RSSRoot;

import java.io.InputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class RSSRequest {
    private static final int CONNECT_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 15000;
    private final String url;

    public RSSRequest(String url) {
        this.url = url;
    }

    public RSSRoot execute() throws Failure {
        try {
            HttpRequest httpRequest = HttpRequest.get(url).readTimeout(READ_TIMEOUT).connectTimeout(CONNECT_TIMEOUT);
            RSSRoot rssRoot = fromStream(httpRequest.buffer());
            return rssRoot;
        } catch (HttpRequest.HttpRequestException e) {
            throw new Failure(e);
        } catch (Exception e) {
            throw new Failure(e);
        }
    }

    private RSSRoot fromStream(InputStream in) throws Exception {
        Serializer serializer = new Persister();
        RSSRoot rssRoot = serializer.read(RSSRoot.class, in);
        in.close();
        return rssRoot;
    }
}
