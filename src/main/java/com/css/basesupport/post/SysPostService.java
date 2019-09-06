package com.css.basesupport.post;

import com.css.basesupport.httpclient.HttpClient;
import com.css.basesupport.httpclient.HttpRequest;
import com.css.basesupport.post.entity.SysPost;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SysPostService {

    @Autowired
    HttpClient httpClient;
    @Value("${spring.basesupport.ip}")
    String ip;
    /**
     * 根据用户ID获取岗位列表
     * @param userId
     * @return
     */
    public List<SysPost>  queryPostsByUser(String userId) {
        if(userId == null  || "".equals(userId)) {
            return null;
        }
        String url = "http://" + ip +"/rest/spost/check?userId="+userId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json =  httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysPost> sysPostList = mapper.readValue(json, new TypeReference<List<SysPost>>(){});
            return sysPostList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据机构ID获取岗位信息
     * @param orgid
     * @return
     */
    public List<SysPost>  queryPostsByOrg(String orgid) {
        if(orgid == null  || "".equals(orgid)) {
            return null;
        }
        String url = "http://" + ip +"/rest/spost/queryPostsByOrg?orgid="+orgid;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json =  httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysPost> sysPostList = mapper.readValue(json, new TypeReference<List<SysPost>>(){});
            return sysPostList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据岗位ID获取岗位信息
     * @param postId
     * @return
     */
    public List<SysPost>  getPost(String postId) {
        if(postId == null  || "".equals(postId)) {
            return null;
        }
        String url = "http://" + ip +"/rest/spost/getPost?postId="+postId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json =  httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysPost> sysPostList = mapper.readValue(json, new TypeReference<List<SysPost>>(){});
            return sysPostList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取全部岗位
     * @return
     */
    public List<SysPost>  getAllPostList () {
        String url = "http://" + ip +"/rest/spost/getAllPostList";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json =  httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysPost> sysPostList = mapper.readValue(json, new TypeReference<List<SysPost>>(){});
            return sysPostList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据postId获取该岗位的用户ID
     * @param postId
     * @return
     */
    public String  getSUserPostbypostId(String postId) {
        String url = "http://" + ip +"/rest/spost/getSUserPostbypostId?postId="+postId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String userIdsJson =  httpClient.doGet(request);
            return userIdsJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过岗位ID查询角色ID
     * @param postId
     * @return
     */
    public String  getRoleIdsByPostId(String postId) {
        String url = "http://" + ip +"/rest/spost/geRoleIdsByPostId?postId="+postId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String roleList =  httpClient.doGet(request);
            return roleList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
