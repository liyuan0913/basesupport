package com.css.basesupport.org.entity;

import lombok.Data;

/**
 * @author leon
 * @version V1.0
 * @description: 组织机构实体类
 * @date 2019/9/5 5:51 下午
 */
@Data
public class SysOrg {
    // 机构Id
    private  String uuid;

    // 机构名称
    private String name;

    // 父节点
    private String parentId;

    // 序号
    private Integer orderNum;

    // 删除标记
    private String delFlag;

    // 开启标记
    private String openFlag;

    // 详情描述
    private String remark;

    // 修改日期
    private String editDate;

    // 机构编码
    private String unitCode;

    // 编码名称
    private String codeName;
}
