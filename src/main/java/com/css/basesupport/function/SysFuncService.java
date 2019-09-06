package com.css.basesupport.function;

import com.css.basesupport.function.entity.SysFunc;
import com.css.basesupport.httpclient.HttpClient;
import com.css.basesupport.httpclient.HttpRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SysFuncService {

    @Autowired
    HttpClient httpClient;

    @Value("${spring.basesupport.ip}")
    private String ip;

    /**
     * 根据用户ID及系统ID获取菜单列表
     *
     * @param userId
     * @return
     */
    public List<SysFunc> listFuncsByUser(String userId) {
        if (userId == null || "".equals(userId)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sfunc/listFuncsByUser=" + userId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysFunc> sysFuncList = mapper.readValue(json, new TypeReference<List<SysFunc>>() {
            });
            return sysFuncList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
