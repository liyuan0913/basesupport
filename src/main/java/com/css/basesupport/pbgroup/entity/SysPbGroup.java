package com.css.basesupport.pbgroup.entity;

import lombok.Data;

@Data
public class SysPbGroup {
    private String pgId;
    private String name;
    private String parentId;
    private String pgDesc;
    private String isParent;
    private String pbGroupId;
    private String itemId;
    private String itemFlag;
}
