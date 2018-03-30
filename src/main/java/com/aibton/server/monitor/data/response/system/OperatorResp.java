/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.data.response.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/30 14:21 huzhihui Exp $$
 */
@ApiModel
public class OperatorResp {

    @ApiModelProperty(value = "操作人名称")
    private String name;

    @ApiModelProperty(value = "分支")
    private String branch;

    @ApiModelProperty(value = "操作时间")
    private Date time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
