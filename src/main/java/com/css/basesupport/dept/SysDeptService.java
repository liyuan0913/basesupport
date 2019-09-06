package com.css.basesupport.dept;

import com.css.basesupport.user.entity.SysUserDept;
import com.css.basesupport.dept.entity.SysDept;
import com.css.basesupport.httpclient.HttpClient;
import com.css.basesupport.httpclient.HttpRequest;
import com.css.basesupport.user.entity.SysUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class SysDeptService {
    @Autowired
    HttpClient httpClient;
    @Value("${spring.basesupport.ip}")
    private String ip;

    /**
     * @param
     * @return
     * @author jiahongguang
     * @description 获取所有的SUserDept的UUID
     * @date 2019/9/6 10:18
     **/
    public String getAllSUserDeptIds() {
        String url = "http://" + ip + "/rest/sdept/getAllSUserDeptIds";
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
     * @param
     * @return
     * @author jiahongguang
     * @description 获取所有的SUserDept的对象
     * @date 2019/9/6 10:18
     **/
    public List<SysUserDept> getAllSUserDept() {

        String url = "http://" + ip + "/rest/sdept/getAllSUserDept";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUserDept> SUserDeptList = mapper.readValue(json, new TypeReference<List<SysUserDept>>() {
            });
            return SUserDeptList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param
     * @return
     * @author jiahongguang
     * @description 根据orgId获取SUserDept的UUID + 3.2.4.11获取部门全部子节点并选中
     * @date 2019/9/6 10:18
     **/

    public String getSUserDeptIdsbyOrgId(String orgId) {
        if (orgId == null || "".equals(orgId)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sdept/getSUserDeptIdsbyOrgId?orgId=" + orgId;
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
     * @param
     * @return
     * @author jiahongguang
     * @description 根据deptIds获取SUserDept对象
     * @date 2019/9/6 10:19
     **/

    public List<SysUserDept> userDeptIdList(List<String> deptIds) {
        if (deptIds == null || deptIds.size() == 0) {
            return null;
        }
        String url = "http://" + ip + "/rest/sdept/getSUserDeptIdsbyOrgId?orgId=" + deptIds;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUserDept> SUserDeptList = mapper.readValue(json, new TypeReference<List<SysUserDept>>() {
            });
            return SUserDeptList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param
     * @return
     * @author jiahongguang
     * @description 通过部门ID查询部门下的人员
     * @date 2019/9/6 10:19
     **/

    public List<SysUser> dirOrgDeptUserByDeptId(String deptId) {
        if (deptId == null || "".equals(deptId)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sdept/dirOrgDeptUserByDeptId?deptId=" + deptId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> SysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return SysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param
     * @return
     * @author jiahongguang
     * @description 通过orgId查询部门下的人员Ids
     * @date 2019/9/6 10:19
     **/


    public String dirSUserDeptByOrgId(String orgId) {
        if (orgId == null || "".equals(orgId)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sdept/dirSUserDeptByOrgId?orgId=" + orgId;
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
     * @param
     * @return
     * @author jiahongguang
     * @description 通过deptId查询部门下的人员Ids
     * @date 2019/9/6 10:19
     **/

    public String dirSUserDeptByDeptId(String deptId) {
        if (deptId == null || "".equals(deptId)) {
            return null;
        }
        String url = "http://" + ip + "/rest/sdept/dirOrgDeptUserByDeptId?deptId=" + deptId;
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
     * @param
     * @return
     * @author jiahongguang
     * @description 根据deptIds获取SOrgDept对象
     * @date 2019/9/6 10:19
     **/
    public List<SysDept> dirSOrgDeptByDeptIds(List<String> deptIds) {
        if (deptIds == null || deptIds.size() == 0) {
            return null;
        }
        String url = "http://" + ip + "/rest/sdept/dirSOrgDeptByDeptIds?deptIds=" + deptIds;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysDept> SysDeptList = mapper.readValue(json, new TypeReference<List<SysDept>>() {
            });
            return SysDeptList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param
     * @return
     * @author jiahongguang
     * @description 获取全部组织机构部门JSON树
     * @date 2019/9/6 10:19
     **/

    public String getJsonTreeAllChildren(String dept, Integer includeSelfYes, Integer openLevel) {
        if (dept == null || "".equals(dept) || includeSelfYes == null || openLevel == null) {
            return null;
        }
        int includeSelfYesSend = includeSelfYes.intValue();
        int openLevelSend = openLevel.intValue();
        String url = "http://" + ip + "/rest/sdept/getJsonTreeAllChildren?dept=" + dept + "&includeSelfYes=" + includeSelfYesSend +
                "&openLevel=" + openLevelSend;
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
     * @param
     * @return
     * @author jiahongguang
     * @description 获取全部组织机构部门List树报错
     * @date 2019/9/6 10:20
     **/
    public List<SysDept> getAllChildren(String dept, Integer includeSelfYes) {
        if (dept == null || "".equals(dept) || includeSelfYes == null) {
            return null;
        }
        int includeSelfYesSend = includeSelfYes.intValue();
        String url = "http://" + ip + "/rest/sdept/getAllChildren?dept=" + dept + "&includeSelfYes=" + includeSelfYesSend;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysDept> SysDeptList = mapper.readValue(json, new TypeReference<List<SysDept>>() {
            });
            return SysDeptList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param
     * @return
     * @author jiahongguang
     * @description 获取全部部门子节点ID
     * @date 2019/9/6 10:20
     **/

    public String getAllChildrenId(String dept, Integer includeSelfYes) {
        if (dept == null || "".equals(dept) || includeSelfYes == null) {
            return null;
        }
        int includeSelfYesSend = includeSelfYes.intValue();
        String url = "http://" + ip + "/rest/sdept/getAllChildrenId?dept=" + dept + "&includeSelfYes=" + includeSelfYesSend;
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


}
