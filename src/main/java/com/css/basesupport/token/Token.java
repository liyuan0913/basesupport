package com.css.basesupport.token;

import com.css.basesupport.httpclient.HttpClient;
import com.css.basesupport.httpclient.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author leon
 * @version V1.0
 * @description: TODO
 * @date 2019/9/5 9:37 上午
 */
@Component
@EnableScheduling
public class Token {
    // token
    private static String token;

    // 系统ID
    @Value("${spring.token.sysId}")
    private int sysId;

    // 服务密钥
    @Value("${spring.token.serverKey}")
    private String serverKey;

    // 微服务的ip
    @Value("${spring.basesupport.ip}")
    String ip;

    @Autowired
    HttpClient httpClient;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Token.token = token;
    }

    //或直接指定时间间隔，例如：30 分钟 = 30 * 60 * 1000
    @Scheduled(fixedRate = 30 * 60 * 1000)
    private void configureTasks() throws Exception {
        // 1.首先判断token是否为空，若为空则为首次创建
        if (token == null) {
            setToken(getTokenfromServer());
        } else { // 2.检测token是否失效,若失效重新向服务器获取token
            if (!checkToken()) {
                setToken(getTokenfromServer());
            }
        }
    }

    // 从服务器获取token
    public String getTokenfromServer() throws Exception {
        // 拼接URL,ip=10.13.1.211:9220/esb
        String url = "http://" + ip + "/rest/api/getToken?sysId=" + sysId + "&serverKey=" + serverKey;
        // httpClient工具类通过URL向服务器请求token
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        String token = httpClient.doGet(request);
        return token;
    }

    // 检测token是否失效
    public Boolean checkToken() throws Exception {
        String url = "http://" + ip + "/rest/api/checkToken?token=" + getToken();
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        String tokenStatus = httpClient.doPost(request);// post
        if ("INVALID".equals(tokenStatus)) { // 若状态为无效的(INVALID)
            return false;
        } else {
            return true;
        }
    }
}
