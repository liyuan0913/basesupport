package com.css.basesupport.dict.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 字典实体
 *
 * @author
 */
@Data
public class SysDict implements Serializable {

    private String uuid;

    private String name;

    private String parentId;

    private String code;

    private String remark;

    private String tableName;

    private Integer orderNum;

    private String tableType;


}
