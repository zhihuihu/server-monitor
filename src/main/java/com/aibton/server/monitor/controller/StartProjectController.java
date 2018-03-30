/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.controller;

import com.aibton.framework.data.ResponseNormal;
import com.aibton.framework.util.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动项目
 *
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/28 14:07 huzhihui Exp $$
 */
@Api(description = "系统项目操作相关接口")
@RestController
@RequestMapping(value = "startProject")
public class StartProjectController {

    @ApiOperation(value = "项目启动")
    @PostMapping(value = "run")
    public ResponseNormal run(String jsonStr) {

        return ResponseUtils.getData(true, "");
    }
}
