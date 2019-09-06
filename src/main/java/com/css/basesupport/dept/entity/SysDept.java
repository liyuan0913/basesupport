package com.css.basesupport.dept.entity;

import lombok.Data;

/**
 * @author jiahongguang
 * @description 组织机构部门表
 * @date  2019/9/6 10:58
 * @param
 * @return
 **/
@Data
public class SysDept {
    private String uuid;
    private String parentId;
    private String orgId;
    private String name;
    private String address;
    private String phone;
    private String fax;
    private String zipCode;
    private String orderNum;
    private int deptCode;
    private int delFlag;
}
