/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.controller;

import com.aibton.framework.data.ResponseNormal;
import com.aibton.framework.util.AssertUtils;
import com.aibton.framework.util.ResponseUtils;
import com.aibton.server.monitor.core.enums.ResponseCommonEnum;
import com.aibton.server.monitor.data.request.RunProjectReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(StartProjectController.class);

    @ApiOperation(value = "项目启动")
    @PostMapping(value = "run")
    public ResponseNormal run(@RequestBody RunProjectReq runProjectReq) {
        AssertUtils.isNotEmpty(LOGGER, runProjectReq.getSysProjectId(), ResponseCommonEnum.PARAM_ERROR);
        AssertUtils.isNotEmpty(LOGGER, runProjectReq.getBranch(), ResponseCommonEnum.PARAM_ERROR);
        AssertUtils.isNotEmpty(LOGGER, runProjectReq.getType(), ResponseCommonEnum.PARAM_ERROR);



        return ResponseUtils.getOtherData(true, "200000", "正在发布");
    }

    @ApiOperation(value = "查询项目启动状态")
    @PostMapping(value = "runStatus")
    public ResponseNormal runStatus() {
        return ResponseUtils.getData(true, "发布成功");
    }
}
