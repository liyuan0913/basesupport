package com.css.basesupport.menu.entity;

import lombok.Data;

import java.util.List;

@Data
public class SysQuickMenu {
    private String uuid;
    private String funcId;
    private String name;
    private String parentId;
    private Integer orderNum;
    private String path;
    private String openFlag;
    private String icon;
    private String openIcon;
    private String fastFlag;
    private String sysId;
    private String color;
}
