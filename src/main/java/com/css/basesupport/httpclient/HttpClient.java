package com.css.basesupport.httpclient;


import com.css.basesupport.token.Token;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class HttpClient {

    @Autowired(required=false)
    private CloseableHttpClient httpClient;


    @Autowired(required=false)
    private RequestConfig config;

    public String doGet(HttpRequest request) throws Exception {
        // 声明 http get 请求
        HttpGet httpGet = new HttpGet(request.getUrl());

        // 装载配置信息
        httpGet.setConfig(config);
        httpGet.addHeader("token", Token.getToken());
        // 发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpGet);

        // 判断状态码是否为200
        if (response.getStatusLine().getStatusCode() == 200) {
            // 返回响应体的内容
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        }
        return null;
    }

    /**
     * 带参数的post请求
     *
     * @return
     * @throws Exception
     */
    public String doPost(HttpRequest request) throws Exception {
        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(request.getUrl());
        // 加入配置信息
        httpPost.setConfig(config);
        httpPost.addHeader("token", Token.getToken());
        // 发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpPost);
       /* return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(
                response.getEntity(), "UTF-8"));*/
        // 判断状态码是否为200
        if (response.getStatusLine().getStatusCode() == 200) {
            // 返回响应体的内容
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        }
        return null;
    }

}
