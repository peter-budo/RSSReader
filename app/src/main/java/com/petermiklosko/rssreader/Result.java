package com.petermiklosko.rssreader;

public enum Result {
    SUCCESS, FAILURE, ERROR, NETWORK_FAILURE("network error"), CANCELLED("cancelled");

    private String message = "";
    private int statusCode;

    private Result(String message) {
        this.message = message;
    }

    private Result() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
