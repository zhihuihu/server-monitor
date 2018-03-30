/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.data.response.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 使用情况
 *
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/30 14:18 huzhihui Exp $$
 */
@ApiModel
public class UsageResp {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "使用百分比")
    private String percent;

    @ApiModelProperty(value = "总量")
    private String total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
