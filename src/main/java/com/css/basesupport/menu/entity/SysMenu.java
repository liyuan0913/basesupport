package com.css.basesupport.menu.entity;

import lombok.Data;

import java.util.List;

@Data
public class SysMenu {
    private String id;
    private String name;
    private String path;
    private String icon;
    private String openIcon;
    private String funcode;
    private Boolean visible;
    private Boolean isLast;
    private String parentId;
    private int level;
    private List<MenuItem> menus;
}
