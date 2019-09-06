package com.css.basesupport.httpclient;

public class HttpRequest {

    // 请求url
    private String url;

    public HttpRequest() {
        super();
    }

    public HttpRequest(Integer code, String url) {
        super();
        this.url = url;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
