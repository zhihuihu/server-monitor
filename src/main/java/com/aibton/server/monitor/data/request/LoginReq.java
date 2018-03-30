/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.data.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/30 9:55 huzhihui Exp $$
 */
@ApiModel
public class LoginReq {


    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "职位")
    private String post;

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
}
