/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.data.response.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/30 14:33 huzhihui Exp $$
 */
@ApiModel
public class ProjectStatusResp {

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "运行状态")
    private String status;

    @ApiModelProperty(value = "分支")
    private String branch;

    @ApiModelProperty(value = "操作人")
    private String operateName;

    @ApiModelProperty(value = "操作时间")
    private String operateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }
}
