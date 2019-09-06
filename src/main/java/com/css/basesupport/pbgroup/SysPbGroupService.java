package com.css.basesupport.pbgroup;

import com.css.basesupport.httpclient.HttpClient;
import com.css.basesupport.httpclient.HttpRequest;
import com.css.basesupport.pbgroup.entity.SysPbGroup;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SysPbGroupService {

    @Autowired
    HttpClient httpClient;

    @Value("${spring.basesupport.ip}")
    private String ip;

    /**
     * 获取公共群组树
     * @return
     */
    public String getPbGroupTree() {

        String url = "http://" + ip +"/rest/spbgroup/getPbGroupTree";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String pbGroupTreeJson =  httpClient.doGet(request);
            return pbGroupTreeJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 按userID查询公共群组文章权限
     * @param userId
     * @return
     */
    public String dirPbGroupItemByUserId(String userId) {
        if(userId == null  || "".equals(userId)) {
            return null;
        }
        String url = "http://" + ip +"/rest/spbgroup/dirPbGroupItemByUserId?userId=" + userId;
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

    /**
     * 按pbGroupID查询公共群组
     * @return
     */
    public List<SysPbGroup> dirPbGroupItemByPbGroupID(String pbGroupId) {
        if(pbGroupId == null  || "".equals(pbGroupId)) {
            return null;
        }
        String url = "http://" + ip +"/rest/spbgroup/dirPbGroupItemByPbGroupID?pbGroupId=" + pbGroupId ;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json =  httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysPbGroup> sysPbGroupList = mapper.readValue(json, new TypeReference<List<SysPbGroup>>(){});
            return sysPbGroupList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
