/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.data.response;

import com.aibton.server.monitor.data.response.system.OperatorResp;
import com.aibton.server.monitor.data.response.system.UsageResp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/30 14:16 huzhihui Exp $$
 */
@ApiModel
public class SysInfoResp {

    @ApiModelProperty(value = "内存")
    private UsageResp memory;

    @ApiModelProperty(value = "CUP")
    private UsageResp cpu;

    @ApiModelProperty(value = "最后操作人")
    private OperatorResp operator;

    public UsageResp getMemory() {
        return memory;
    }

    public void setMemory(UsageResp memory) {
        this.memory = memory;
    }

    public UsageResp getCpu() {
        return cpu;
    }

    public void setCpu(UsageResp cpu) {
        this.cpu = cpu;
    }

    public OperatorResp getOperator() {
        return operator;
    }

    public void setOperator(OperatorResp operator) {
        this.operator = operator;
    }
}
