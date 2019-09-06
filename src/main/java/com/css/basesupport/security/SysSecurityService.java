package com.css.basesupport.security;

import com.css.basesupport.httpclient.HttpClient;
import com.css.basesupport.httpclient.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SysSecurityService {

    @Autowired
    HttpClient httpClient;

    @Value("${spring.basesupport.ip}")
    private String ip;
    /**
     * 判断是否是CA登录
     * @return
     */
    public Boolean  isCA() {
        String url = "http://" + ip +"/rest/security/isCA";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String result =  httpClient.doGet(request);
            if("true".equals(result)){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据参数ID获取参数值
     * @param paramId
     * @return
     */
    public String  getParamValue(String paramId) {
        String url = "http://" + ip +"/rest/security/getParamValue?paramId =" + paramId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json =  httpClient.doGet(request);
            return json;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
