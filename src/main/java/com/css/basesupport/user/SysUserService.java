package com.css.basesupport.user;

import com.alibaba.fastjson.JSONObject;
import com.css.basesupport.Result;
import com.css.basesupport.dept.entity.SysDept;
import com.css.basesupport.function.entity.SysFunc;
import com.css.basesupport.httpclient.HttpClient;
import com.css.basesupport.httpclient.HttpRequest;
import com.css.basesupport.menu.entity.SysMenu;
import com.css.basesupport.system.entity.Sys;
import com.css.basesupport.user.entity.SysUser;
import com.css.basesupport.user.entity.SysUserDept;
import com.css.basesupport.user.entity.SysUserPost;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SysUserService {
    @Value("${spring.basesupport.ip}")
    String ip;

    @Autowired
    HttpClient httpClient;

    /**
     * 验证用户名和密码
     *
     * @return
     */
    public Result<SysUser> checkUserInfo(String loginName, String password) {
        Result<SysUser> result = new Result<SysUser>();
        if (loginName == null || "".equals(loginName) || password == null || "".equals(password)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/check?loginName=" + loginName + "&password = " + password;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            String str = json.substring(0, json.indexOf("{"));
            String str1 = "{" + str.substring(1) + "\"\"}";
            JSONObject jsobj = (JSONObject) JSONObject.toJSON(str1);
            result.setResultCode(jsobj.getString("resultCode"));
            result.setResultDesc(jsobj.getString("resultDesc"));

            String jsons = "[ " + json.substring(str.length() + 1, json.length());
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(jsons, new TypeReference<List<SysUser>>() {
            });
            result.setResult(sysUserList.get(0));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据登录名获取用户基本信息
     *
     * @return
     */
    public SysUser getAuthUserInfo(String loginName) {
        if (loginName == null || "".equals(loginName)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getAuth?loginName=" + loginName;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据用户ID获取用户
     *
     * @return
     */
    public SysUser getUserInfo(String userId) {
        if (userId == null || "".equals(userId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getUser?userId=" + userId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据用户LoginName获取用户
     *
     * @return
     */
    public SysUser getUserByName(String loginName) {
        if (loginName == null || "".equals(loginName)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getUserByName?loginName=" + loginName;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据用户realName获取用户
     *
     * @return
     */
    public List<SysUser> queryUsersByName(String realName) {
        if (realName == null || "".equals(realName)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/queryUsersByName?loginName=" + realName;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据用户roleId获取用户list
     *
     * @return
     */
    public List<SysUser> queryUsersByRole(String roleId) {
        if (roleId == null || "".equals(roleId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/queryUsersByRole?roleId=" + roleId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据用户roleId获取用户ids
     *
     * @return
     */
    public String queryUserIdsByRole(String roleId) {
        if (roleId == null || "".equals(roleId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/queryUserIdsByRole?roleId=" + roleId;
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
     * 根据用户id获取菜单列表
     *
     * @return
     */
    public List<SysMenu> getSMenusByUserId(String userId) {
        if (userId == null || "".equals(userId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getSMenusByUserId?userId=" + userId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysMenu> sysMenuList = mapper.readValue(json, new TypeReference<List<SysMenu>>() {
            });
            return sysMenuList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据组织机构id获取用户列表
     *
     * @return
     */
    public List<SysUser> queryUsersByOrg(String orgId) {
        if (orgId == null || "".equals(orgId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/queryUsersByOrg?orgId=" + orgId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据组织机构id,岗位id获取用户列表
     *
     * @return
     */
    public List<SysUser> queryUsersByOrg(String orgId, String postId) {
        if (orgId == null || "".equals(orgId) || postId == null || "".equals(postId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/queryUsersByOrgPost?orgId=" + orgId + "postId" + postId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据组织机构id,岗位id获取所有下级用户列表
     *
     * @return
     */
    public List<SysUser> getUsersByParentOrgIdAndPostId(String orgId, String postId) {
        if (orgId == null || "".equals(orgId) || postId == null || "".equals(postId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getUsersByParentOrgIdAndPostId?orgId=" + orgId + "postId" + postId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据岗位id获取用户列表
     *
     * @return
     */
    public List<SysUser> queryUsersByPost(String postId) {
        if (postId == null || "".equals(postId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/queryUsersByPost?postId=" + postId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据用户id获取部门列表
     *
     * @return
     */
    public List<SysDept> getSOrgDeptByUserId(String userId) {
        if (userId == null || "".equals(userId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getSOrgDeptByUserId?userId=" + userId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysDept> sysDeptList = mapper.readValue(json, new TypeReference<List<SysDept>>() {
            });
            return sysDeptList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据用户id获取部门ids
     *
     * @return
     */
    public String getSOrgDeptIdByUserId(String userId) {
        if (userId == null || "".equals(userId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getSOrgDeptIdByUserId?userId=" + userId;
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
     * 根据特定条件查询用户
     *
     * @return
     */
    public List<SysUser> listUserByConditions(String conditions) {
        if (conditions == null || "".equals(conditions)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/listUserByConditions?conditions=" + conditions;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<SysUser> listUserByConditions() {

        String url = "http://" + ip + "/rest/suser/listAllUser";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取当前用户的秘书ID
     *
     * @return
     */
    public String listSecretaryByUserId(String userId) {
        if (userId == null || "".equals(userId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/listSecretaryByUserId?userId=" + userId;
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
     * 获取当前用户的领导ID
     *
     * @return
     */
    public String listLeaderByUserId(String userId) {
        if (userId == null || "".equals(userId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/listLeaderByUserId?userId=" + userId;
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
     * 获取所有领导ID
     *
     * @return
     */
    public List<SysUser> listAllLeader() {

        String url = "http://" + ip + "/rest/suser/listAllLeader";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据部门id获取用户列表
     *
     * @return
     */
    public List<SysUser> queryUsersByDeptId(String deptId) {
        if (deptId == null || "".equals(deptId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/queryUsersByDeptId?deptId=" + deptId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据系统ID获取可登陆用户列表
     *
     * @return
     */
    public List<SysUser> getLoginUserListBySysId(String sysId) {
        if (sysId == null || "".equals(sysId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getLoginUserListBySysId?sysId=" + sysId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据用户uuid获取相关的 SUserPost列表
     *
     * @return
     */
    public List<SysUserPost> getUserPostList(String uuid) {
        if (uuid == null || "".equals(uuid)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getUserPostList?uuid=" + uuid;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUserPost> sysUserPostList = mapper.readValue(json, new TypeReference<List<SysUserPost>>() {
            });
            return sysUserPostList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据用户ID获取相关的系统列表
     *
     * @return
     */
    public List<Sys> listSysListByUser(String userId) {
        if (userId == null || "".equals(userId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/listSysListByUser?userId=" + userId;
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
     * 修改密码
     *
     * @return
     */
    public SysUser updUserPassword(String oldPassword, String newPassword, String userId) {
        if (oldPassword == null || "".equals(oldPassword) || newPassword == null || "".equals(newPassword) || userId == null || "".equals(userId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/updUserPassword?oldPassword=" + oldPassword + "newPassword" + newPassword + "userId" + userId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doPost(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取失败登录次数
     *
     * @return
     */
    public SysUser getFailedLoginCount(String loginName) {
        if (loginName == null || "".equals(loginName)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getFailedLoginCount?loginName=" + loginName;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 修改失败登录次数
     *
     * @return
     */
    public SysUser updateFailedLoginCount(String loginName) {
        if (loginName == null || "".equals(loginName)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/updateFailedLoginCount?loginName=" + loginName;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 依据缓存设置当前用户的功能编码和功能项(所有开启且已去重的功能编码、功能项)
     *
     * @return
     */
    public List<SysFunc> setUserAuthByCache(String currentUser) {
        if (currentUser == null || "".equals(currentUser)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/setUserAuthByCache?currentUser=" + currentUser;
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

    /**
     * 通过用户名密码获取用户
     *
     * @return
     */
    public SysUser getUserByLoginNamePwd(String loginName, String password) {
        if (loginName == null || "".equals(loginName) || password == null || "".equals(password)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getUserByLoginNamePwd?loginName=" + loginName + "&password = " + password;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 查询当前用户所属功能项
     *
     * @return
     */
    public String setUserFuncByCache(SysUser user) {
        if (user == null) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/setUserFuncByCache?user=" + user;
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
     * 查询当前用户所属功能action
     *
     * @return
     */
    public String setUserFuncActionByCache(SysUser user) {
        if (user == null) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/setUserFuncActionByCache?user=" + user;
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
     * 根据userId获取用户姓名
     *
     * @return
     */
    public String getUserRealNameById(String userId) {
        if (userId == null || "".equals(userId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getUserRealNameById?userId=" + userId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<String> strList = mapper.readValue(json, new TypeReference<List<String>>() {
            });
            return strList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 通过用户ID查询用户部门关联数据
     *
     * @return
     */
    public List<SysUserDept> getSUserDeptByUserId(String userId) {
        if (userId == null || "".equals(userId)) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getSUserDeptByUserId?userId=" + userId;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUserDept> sysUserDeptList = mapper.readValue(json, new TypeReference<List<SysUserDept>>() {
            });
            return sysUserDeptList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取全部用户ID
     *
     * @return
     */
    public String getAllSUserIds() {

        String url = "http://" + ip + "/rest/suser/getAllSUserIds";
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
     * 根据用户Ids获取用户
     *
     * @return
     */
    public List<SysUser> getSUserByIds(List<String> isList) {
        if (isList == null) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/getSUserByIds?ids=" + isList;
        HttpRequest request = new HttpRequest();
        request.setUrl(url);

        try {
            String json = httpClient.doGet(request);
            final ObjectMapper mapper = new ObjectMapper();
            List<SysUser> sysUserList = mapper.readValue(json, new TypeReference<List<SysUser>>() {
            });
            return sysUserList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取全部用户ID
     *
     * @return
     */
    public String orderUsers(List<String> isList) {
        if (isList == null) {
            return null;
        }

        String url = "http://" + ip + "/rest/suser/orderUsers?ids=" + isList;
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
