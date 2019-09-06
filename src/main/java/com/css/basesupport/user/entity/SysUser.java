package com.css.basesupport.user.entity;

import com.css.basesupport.dept.entity.SysDept;
import com.css.basesupport.function.entity.SysFunc;
import com.css.basesupport.org.entity.SysOrg;
import com.css.basesupport.post.entity.SysPost;
import com.css.basesupport.system.entity.Sys;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class SysUser {
    private String uuid;
    private String realName;
    private String loginName;
    private String password;
    private String sex;
    private String mobile;
    private String phone;
    private String email;
    private String userType;
    private Integer orderNum;
    private String delFlag;
    private String openFlag;
    private Date issueDate;
    private String issueId;
    private String issueName;
    private Date editDate;
    private String remark;
    private String lastLoginTime;
    private Integer totalLoginCount;
    private Integer failedLoginCount;
    private String orgId;
    private Date editPwdTime;
    private String activeStatus;
    private Date activeDeadLine;
    private String secLevel;
    private java.util.Set<String> functions;
    private java.util.Set<String> funcActions;
    private List<Sys> syss;
    private List<SysDept> depts;
    private List<SysRole> roles;
    private List<SysPost> posts;
    private List<SysUserPost> userPosts;
    private List<SysOrg> orgs;
    private List<SysFunc> funcs;
    private List<SysFuncAction> actions;

}
