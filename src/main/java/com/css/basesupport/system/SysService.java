package com.css.basesupport.system;

import com.css.basesupport.httpclient.HttpClient;
import com.css.basesupport.httpclient.HttpRequest;
import com.css.basesupport.system.entity.Sys;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class SysService {
    @Autowired
    HttpClient httpClient;
    @Value("${spring.basesupport.ip}")
    private static String ip;

    /**
     * @param
     * @return
     * @author jiahongguang
     * @description 根据用户ID获取拥有权限系统
     * @date 2019/9/6 10:20
     **/
    public List<Sys> getSysAuth(String userId) {

        if (userId == null || "".equals(userId)) {
            return null;
        }
        String url = "http://" + ip + "/rest/ssys/getSysAuth?userId=" + userId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<Sys> sysList = mapper.readValue(json, new TypeReference<List<Sys>>() {
            });
            return sysList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param
     * @return
     * @author jiahongguang
     * @description 根据系统ID获取系统
     * @date 2019/9/6 10:20
     **/
    public Sys getSys(String sysId) {

        if (sysId == null || "".equals(sysId)) {
            return null;
        }
        String url = "http://" + ip + "/rest/ssys/getSys?sysId=" + sysId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<Sys> sys = mapper.readValue(json, new TypeReference<List<Sys>>() {
            });
            return sys.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param
     * @return
     * @author jiahongguang
     * @description 查询所有系统报错
     * @date 2019/9/6 10:20
     **/
    public List<Sys> getSysList() {

        String url = "http://" + ip + "/rest/ssys/getSysList";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<Sys> sysList = mapper.readValue(json, new TypeReference<List<Sys>>() {
            });
            return sysList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param
     * @return
     * @author jiahongguang
     * @description 根据系统名或编码获得系统，输入系统名返回空
     * @date 2019/9/6 10:21
     **/
    public Sys getSysByNameOrCode(String param) {

        String url = "http://" + ip + "/rest/ssys/getSysByNameOrCode?param=" + param;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<Sys> sysList = mapper.readValue(json, new TypeReference<List<Sys>>() {
            });
            return sysList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
