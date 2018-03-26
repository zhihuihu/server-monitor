/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 拥有项目
 *
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 18:29 huzhihui Exp $$
 */
@Table(name = "sys_project")
@Entity
public class SysProject {

    @Id
    private String id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目具体值
     */
    private String value;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
