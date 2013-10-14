package com.petermiklosko.rssreader;

import java.io.IOException;
import java.util.Map;

import org.mockito.Mockito;

import fi.iki.elonen.NanoHTTPD;

public class StubServerApplication extends RSSApplication {
    final NanoHTTPD server = Mockito.spy(new MyHTTPD(8080));

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void resumeServer() {
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pauseServer() {
        server.stop();
    }

    public static class MyHTTPD extends NanoHTTPD {

        public MyHTTPD(int port) {
            super(port);
        }

        @Override
        public NanoHTTPD.Response serve(String uri, Method method, Map<String, String> headers, Map<String, String> params, Map<String, String> files) {
            if (method == Method.HEAD) {
                NanoHTTPD.Response response = new Response(Response.Status.OK, MIME_HTML, "");
                response.addHeader("ETag", "123");
                return response;
            }
            throw new AssertionError();
        }
    }
}
