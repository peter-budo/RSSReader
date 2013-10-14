package com.petermiklosko.rssreader.connection;

public class Failure extends Exception {
    public Failure(Exception e) {
        super(e);
    }

    public Failure() {
    }
}
