package com.css.basesupport.org;

import com.alibaba.fastjson.JSONArray;
import com.css.basesupport.httpclient.HttpClient;
import com.css.basesupport.httpclient.HttpRequest;
import com.css.basesupport.org.entity.DeptTree;
import com.css.basesupport.org.entity.SysOrg;
import com.css.basesupport.dept.entity.SysDept;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author leon
 * @version V1.0
 * @description: 系统组织服务
 * @date 2019/9/5 5:52 下午
 */
@Component
public class SysOrgService {
    @Autowired
    HttpClient httpClient;

    @Value("${spring.basesupport.ip}")
    String ip;

    /**
     * @param orgId
     * @return SysOrg
     * @author leon
     * @description 1.根据组织机构Id获取SOrg对象
     * @date 2019/9/5 6:18 下午
     **/
    public SysOrg getOrg(String orgId) {
        if (orgId == null || "".equals(orgId)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sorg/getOrg?orgId=" + orgId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysOrg> sysOrgList = mapper.readValue(json, new TypeReference<List<SysOrg>>() {
            });
            return sysOrgList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param orgIds
     * @return List<SysOrg>
     * @author leon
     * @description 2.根据组织机构Ids获取SOrg对象列表
     * @date 2019/9/5 6:19 下午
     **/
    public List<SysOrg> getOrgs(List<String> orgIds) {
        if (orgIds == null || orgIds.size() == 0) {
            return null;
        }
        String url = "http://" + ip + "/rest/sorg/getOrgs?orgId=" + orgIds;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysOrg> sysOrgList = mapper.readValue(json, new TypeReference<List<SysOrg>>() {
            });
            return sysOrgList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param
     * @return String
     * @author leon
     * @description 3.获取所有组织机构Ids
     * @date 2019/9/5 6:24 下午
     **/
    public String getOrgIds() {
        String url = "http://" + ip + "/rest/sorg/listOrgIds";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param
     * @return List<DeptTree>
     * @author leon
     * @description 4.获取所有组织机构树
     * @date 2019/9/5 6:54 下午
     **/
    public List<DeptTree> getAllOrgTree() {
        String url = "http://" + ip + "/rest/sorg/listAllOrgTree";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<DeptTree> deptTreeList = mapper.readValue(json, new TypeReference<List<DeptTree>>() {
            });
            return deptTreeList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param orgId
     * @return List<DeptTree>
     * @author leon
     * @description 5.根据父节点Id获取组织机构树
     * @date 2019/9/5 7:03 下午
     **/
    public List<DeptTree> getOrgTreeByPId(String orgId) {
        if (orgId == null || "".equals(orgId)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sorg/listOrgTree?pid=" + orgId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<DeptTree> deptTreeList = mapper.readValue(json, new TypeReference<List<DeptTree>>() {
            });
            return deptTreeList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param orderFields
     * @return List<SysOrg>
     * @author leon
     * @description 6.根据排序字段获取有序组织机构
     * @date 2019/9/5 7:11 下午
     **/
    public List<SysOrg> getOrderedOrg(List<String> orderFields) {
        if (orderFields == null || orderFields.size() == 0) {
            return null;
        }
        String url = "http://" + ip + "/rest/sorg/listOrderdOrg?orderFields=" + orderFields;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysOrg> sysOrgList = mapper.readValue(json, new TypeReference<List<SysOrg>>() {
            });
            return sysOrgList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param
     * @return
     * @author leon
     * @description 7.获取所有SOrg
     * @date 2019/9/5 7:20 下午
     **/
    public List<SysOrg> getAllOrg() {
        String url = "http://" + ip + "/rest/sorg/listAllOrg";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysOrg> sysOrgList = mapper.readValue(json, new TypeReference<List<SysOrg>>() {
            });
            return sysOrgList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param
     * @return
     * @author leon
     * @description 8.获取所有SOrgDept
     * @date 2019/9/5 7:25 下午
     **/
    public List<SysDept> getAllOrgDept() {
        String url = "http://" + ip + "/rest/sorg/getAllSOrgDept";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysDept> sysOrgDeptList = mapper.readValue(json, new TypeReference<List<SysDept>>() {
            });
            return sysOrgDeptList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param
     * @return
     * @author leon
     * @description 9.通过组织机构ID获取所有部门树
     * @date 2019/9/5 7:30 下午
     **/
    public List<DeptTree> getAllSDeptTreeByOrgId(String orgId) {
        if (orgId == null || "".equals(orgId)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sorg/getAllSDeptTreeByOrgId?orgId=" + orgId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<DeptTree> deptTreeList = mapper.readValue(json, new TypeReference<List<DeptTree>>() {
            });
            return deptTreeList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param
     * @return
     * @author leon
     * @description 10.获取全部组织机构树
     * @date 2019/9/5 7:35 下午
     **/
    public List<DeptTree> getAllSOrgDeptTree() {
        String url = "http://" + ip + "/rest/sorg/getAllSOrgDeptTree";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<DeptTree> deptTreeList = mapper.readValue(json, new TypeReference<List<DeptTree>>() {
            });
            return deptTreeList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param
     * @return
     * @author leon
     * @description 11.根据orgId获取所有父节点ID（包括自身）
     * @date 2019/9/5 7:38 下午
     **/
    public String getAllSDeptTree(String orgId, JSONArray jsonArray) {
        if (orgId == null || "".equals(orgId) || jsonArray == null || "".equals(jsonArray)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sorg/getAllSDeptTree?orgId=" + orgId
                + "&jsonArray=" + jsonArray;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param
     * @return
     * @author leon
     * @description 12.获取所有组织机构ID
     * @date 2019/9/5 7:50 下午
     **/
    public String getAllSOrgId() {
        String url = "http://" + ip + "/rest/sorg/getAllSOrg";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param
     * @return
     * @author leon
     * @description 13.获取组织机构全部JSON树
     * @date 2019/9/5 7:52 下午
     **/
    public List<DeptTree> getJsonTreeAllChildren(SysOrg sysOrg, String includeSelfNo, String openLevel) {

        if (sysOrg == null || includeSelfNo == null || "".equals(includeSelfNo)
                || openLevel == null || "".equals(openLevel)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sorg/getJsonTreeAllChildren?sOrg=" + sysOrg +
                "&includeSelfNo=" + includeSelfNo + "&openLevel=" + openLevel;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<DeptTree> deptTreeList = mapper.readValue(json, new TypeReference<List<DeptTree>>() {
            });
            return deptTreeList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param sysOrg,includeSelfYes
     * @return String
     * @author leon
     * @description 14.获取全部子节点ID
     * @date 2019/9/5 7:59 下午
     **/
    public String getAllChildrenId(SysOrg sysOrg, String includeSelfYes) {
        if (sysOrg == null || includeSelfYes == null || "".equals(includeSelfYes)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sorg/getAllChildrenId?sOrg=" + sysOrg +
                "&includeSelfYes=" + includeSelfYes;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param unitCode
     * @return String
     * @author leon
     * @description 15.通过机构编码获取机构
     * @date 2019/9/5 8:04 下午
     **/
    public SysOrg getOrgByUnitCode(String unitCode) {
        if (unitCode == null || "".equals(unitCode)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sorg/getOrgByUnitCode?unitCode=" + unitCode;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysOrg> sysOrgList = mapper.readValue(json, new TypeReference<List<SysOrg>>() {
            });
            return sysOrgList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param uuid,orgId
     * @return String
     * @author leon
     * @description 16.拼接机构名称
     * @date 2019/9/5 8:07 下午
     **/
    public String getOrgName(String uuid, String orgId) {
        if (uuid == null || "".equals(uuid) || orgId == null || "".equals(orgId)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sorg/getOrgName?uuid=" + uuid + "&orgId=" + orgId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        try {
            String json = httpClient.doGet(request);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
