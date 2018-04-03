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
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 18:22 huzhihui Exp $$
 */
@Entity
@Table(name = "start_record")
public class StartRecord implements Serializable {

    @Id
    private String id;

    /**
     * 项目id
     */
    private String sysProjectId;

    /**
     * 项目名称
     */
    private String sysProjectName;

    /**
     * 操作人id
     */
    private String operateSysUserId;

    /**
     * 操作人名称
     */
    private String operateSysUserName;

    /**
     * 操作分支
     */
    private String operateBranch;

    /**
     * 其他信息
     */
    private String extMap;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 完成时间
     */
    private Date finishTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSysProjectId() {
        return sysProjectId;
    }

    public void setSysProjectId(String sysProjectId) {
        this.sysProjectId = sysProjectId;
    }

    public String getSysProjectName() {
        return sysProjectName;
    }

    public void setSysProjectName(String sysProjectName) {
        this.sysProjectName = sysProjectName;
    }

    public String getOperateSysUserId() {
        return operateSysUserId;
    }

    public void setOperateSysUserId(String operateSysUserId) {
        this.operateSysUserId = operateSysUserId;
    }

    public String getOperateSysUserName() {
        return operateSysUserName;
    }

    public void setOperateSysUserName(String operateSysUserName) {
        this.operateSysUserName = operateSysUserName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getExtMap() {
        return extMap;
    }

    public void setExtMap(String extMap) {
        this.extMap = extMap;
    }

    public String getOperateBranch() {
        return operateBranch;
    }

    public void setOperateBranch(String operateBranch) {
        this.operateBranch = operateBranch;
    }
}
