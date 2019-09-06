package com.css.basesupport.system.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Sys {
    private String sysid;
    private String name;
    private String url;
    private String serverUrl;
    private String serverKey;
    private String openFlag;
    private String delFlag;
    private String appUrl;
    private String picUrl;
    private Double versionNum;
    private Date updTime;
    private String appModel;
    private String appSource;
    private String appMemo;
    private String isDefaultApp;
    private String isPushApp;
}
