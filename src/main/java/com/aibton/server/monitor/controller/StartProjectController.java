/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.controller;

import com.aibton.framework.data.ResponseNormal;
import com.aibton.framework.util.AssertUtils;
import com.aibton.framework.util.JackSonUtils;
import com.aibton.framework.util.ResponseUtils;
import com.aibton.server.monitor.core.enums.ResponseBusEnum;
import com.aibton.server.monitor.core.enums.ResponseCommonEnum;
import com.aibton.server.monitor.core.utils.IdWorkerUtils;
import com.aibton.server.monitor.core.utils.SessionUtils;
import com.aibton.server.monitor.dao.StartRecordRepository;
import com.aibton.server.monitor.dao.SysProjectRepository;
import com.aibton.server.monitor.data.request.RunProjectReq;
import com.aibton.server.monitor.entity.StartRecord;
import com.aibton.server.monitor.entity.SysProject;
import com.aibton.server.monitor.entity.SysUser;
import com.aibton.server.monitor.interceptor.UrlAuth;
import com.aibton.server.monitor.interceptor.UrlAuthTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private StartRecordRepository startRecordRepository;

    @Autowired
    private SysProjectRepository sysProjectRepository;

    @ApiOperation(value = "项目启动")
    @UrlAuth(value = UrlAuthTypeEnum.NEED_LOGIN)
    @PostMapping(value = "run")
    public ResponseNormal run(@RequestBody RunProjectReq runProjectReq) throws Exception {
        AssertUtils.isNotEmpty(LOGGER, runProjectReq.getSysProjectId(), ResponseCommonEnum.PARAM_ERROR);
        AssertUtils.isNotEmpty(LOGGER, runProjectReq.getBranch(), ResponseCommonEnum.PARAM_ERROR);
        AssertUtils.isNotEmpty(LOGGER, runProjectReq.getType(), ResponseCommonEnum.PARAM_ERROR);
        SysUser loginSysUser = SessionUtils.getLoginUserInfo();
        System.out.println(JackSonUtils.objectToJsonStr(loginSysUser));

        asyncStartProject(runProjectReq, loginSysUser);

        return ResponseUtils.getOtherData(true, ResponseBusEnum.PROJECT_STARTING.getCode(), ResponseBusEnum.PROJECT_STARTING.getValue());
    }

    @Async
    public void asyncStartProject(RunProjectReq runProjectReq, SysUser loginSysUser) throws IOException {
        Process process;
        StartRecord startRecord = new StartRecord();
        startRecord.setId(IdWorkerUtils.getId());
        startRecord.setSysProjectId(runProjectReq.getSysProjectId());
        startRecord.setSysProjectName(runProjectReq.getSysProjectName());
        startRecord.setOperateSysUserId(loginSysUser.getId());
        startRecord.setOperateSysUserName(loginSysUser.getName());
        startRecord.setOperateBranch(runProjectReq.getBranch());
        startRecord.setCreateTime(new Date());
        startRecordRepository.save(startRecord);
        SysProject sysProject = sysProjectRepository.getOne(runProjectReq.getSysProjectId());
        String cmd = "cbd " + sysProject.getName() + " " + runProjectReq.getBranch() + " " + sysProject.getPidSearchValue()
                + " " + sysProject.getBuildFolder() + " " + sysProject.getDeployProjectFolderName() + " " + sysProject.getDeployFolder()
                + " " + sysProject.getStartCmdFolder() + " " + sysProject.getOpenConnectUrl();
        String[] cmds = new String[]{
                "/bin/sh",
                "-c",
                cmd
        };
        System.out.println("----执行开始");
        process = Runtime.getRuntime().exec(cmds);
        System.out.println("----执行完成");
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = input.readLine()) != null) {
            List<String> splits = Arrays.asList(line.split("\\s+"));
            System.out.println(line);
        }
    }

    @ApiOperation(value = "查询项目启动状态")
    @UrlAuth(value = UrlAuthTypeEnum.NEED_LOGIN)
    @PostMapping(value = "runStatus")
    public ResponseNormal runStatus() {
        return ResponseUtils.getOtherData(true, ResponseBusEnum.PROJECT_START_SUCCESS.getCode(), ResponseBusEnum.PROJECT_START_SUCCESS.getValue());
    }

}
