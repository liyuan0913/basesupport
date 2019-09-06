package com.css.basesupport.menu;

import com.css.basesupport.httpclient.HttpClient;
import com.css.basesupport.httpclient.HttpRequest;
import com.css.basesupport.menu.entity.SysMenu;
import com.css.basesupport.menu.entity.SysQuickMenu;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SysMenuService {

    @Autowired
    HttpClient httpClient;
    @Value("${spring.basesupport.ip}")
    private String ip;

    /**
     * 根据用户ID及系统ID获取菜单列表
     * @param userId
     * @return
     */
    public List<SysMenu>  listMenus(String userId, String sysId) {
        if(userId == null  || "".equals(userId)||sysId == null  || "".equals(sysId)) {
            return null;
        }
        String url = "http://" + ip +"/rest/smenu/listMenus?userId="+userId+"&sysId = " +sysId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json =  httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysMenu> sysMenuList = mapper.readValue(json, new TypeReference<List<SysMenu>>(){});
            return sysMenuList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据系统ID获取快捷菜单
     * @param sysId
     * @return
     */
    public List<SysQuickMenu>  getFastMenuList(String sysId) {
        if(sysId == null  || "".equals(sysId)) {
            return null;
        }
        String url = "http://" + ip +"/rest/smenu/getFastMenuList?sysId = " +sysId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json =  httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysQuickMenu> sysQuickMenuList = mapper.readValue(json, new TypeReference<List<SysQuickMenu>>(){});
            return sysQuickMenuList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据系统ID获取系统菜单
     * @param userId
     * @return
     */
    public List<SysMenu>  getUserMenu(String userId, String sysId) {
        if(userId == null  || "".equals(userId)||sysId == null  || "".equals(sysId)) {
            return null;
        }
        String url = "http://" + ip +"/rest/smenu/getUserMenu?userId="+userId+"&sysId = " +sysId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json =  httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysMenu> sysMenuList = mapper.readValue(json, new TypeReference<List<SysMenu>>(){});
            return sysMenuList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
