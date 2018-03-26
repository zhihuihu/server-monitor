/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统操作人员
 *
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 14:32 huzhihui Exp $$
 */
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {

    @Id
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 职位
     */
    private String post;

    /**
     * 登录时间
     */
    private Date loginTime;

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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
