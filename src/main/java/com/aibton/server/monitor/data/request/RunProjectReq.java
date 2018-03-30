/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.data.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/30 14:59 huzhihui Exp $$
 */
@ApiModel
public class RunProjectReq {

    @ApiModelProperty(value = "项目ID")
    private String sysProjectId;

    @ApiModelProperty(value = "分支名称")
    private String branch;

    @ApiModelProperty(value = "启动方式")
    private String type;

    public String getSysProjectId() {
        return sysProjectId;
    }

    public void setSysProjectId(String sysProjectId) {
        this.sysProjectId = sysProjectId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
