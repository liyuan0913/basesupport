package com.css.basesupport.dict;

import com.css.basesupport.dict.entity.SysDict;
import com.css.basesupport.httpclient.HttpClient;
import com.css.basesupport.httpclient.HttpRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SysDictService {

    @Value("${spring.basesupport.ip}")
    String ip;
    @Autowired
    HttpClient httpClient;


    /**
     * 根据字典表名获取字典列表
     *
     * @return
     */
    public List<SysDict> queryDictListByTable(String table) {
        if (table == null || "".equals(table)) {
            return null;
        }

        String url = "http://" + ip + "/rest/sdict/queryDictListByTable?table=" + table;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysDict> sysDictList = mapper.readValue(json, new TypeReference<List<SysDict>>() {
            });
            return sysDictList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据字典表名和编号获取字典项
     *
     * @return
     */
    public SysDict queryDictByTableCode(String table, String code) {
        if (table == null || "".equals(table) || code == null || "".equals(code)) {
            return null;
        }

        String url = "http://" + ip + "/rest/sdict/queryDictByTableCode?table=" + table + "code" + code;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            SysDict sysDict = mapper.readValue(json, new TypeReference<SysDict>() {
            });
            return sysDict;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取字典的字典项列表
     *
     * @return
     */
    public List<SysDict> getChildren(SysDict dict) {
        if (dict == null) {
            return null;
        }

        String url = "http://" + ip + "/rest/sdict/getChildren?dict=" + dict;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysDict> sysDictList = mapper.readValue(json, new TypeReference<List<SysDict>>() {
            });
            return sysDictList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取字典的字典项ID列表
     *
     * @return
     */
    public String getChildrenId(SysDict dict) {
        if (dict == null || "".equals(dict)) {
            return null;
        }

        String url = "http://" + ip + "/rest/sdict/getChildrenId?dict=" + dict;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据字典uuid获取字典
     *
     * @return
     */
    public SysDict getDictByUuid(String uuid) {
        if (uuid == null || "".equals(uuid)) {
            return null;
        }

        String url = "http://" + ip + "/rest/sdict/getDictByUuid?uuid=" + uuid;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            SysDict sysDict = mapper.readValue(json, new TypeReference<SysDict>() {
            });
            return sysDict;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据字典id列表获取字典列表
     *
     * @return
     */
    public List<SysDict> getDictByUuid(List<String> dictIds) {
        if (dictIds == null || "".equals(dictIds)) {
            return null;
        }
        List<SysDict> dictList = new ArrayList<>();

        for (String dictId : dictIds) {
            String url = "http://" + ip + "/rest/sdict/getDictByUuid?uuid=" + dictId;
            HttpRequest request = new HttpRequest();
            request.setUrl(url);

            try {
                String json = httpClient.doGet(request);
                final ObjectMapper mapper = new ObjectMapper();
                List<SysDict> sysDictList = mapper.readValue(json, new TypeReference<List<SysDict>>() {
                });
                dictList.add(sysDictList.get(0));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return dictList;

    }

}
