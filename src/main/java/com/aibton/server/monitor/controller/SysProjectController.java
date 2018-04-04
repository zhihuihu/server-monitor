/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.controller;

import com.aibton.framework.data.ResponseNormal;
import com.aibton.framework.util.AssertUtils;
import com.aibton.framework.util.ResponseUtils;
import com.aibton.server.monitor.config.UserSystemProperties;
import com.aibton.server.monitor.core.enums.ResponseCommonEnum;
import com.aibton.server.monitor.core.utils.IdWorkerUtils;
import com.aibton.server.monitor.dao.SysProjectRepository;
import com.aibton.server.monitor.data.request.SysProjectAddReq;
import com.aibton.server.monitor.entity.SysProject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 18:37 huzhihui Exp $$
 */
@Api(description = "系统项目相关接口")
@RestController
@RequestMapping(value = "sysProject")
public class SysProjectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysProjectController.class);

    @Autowired
    private SysProjectRepository sysProjectRepository;
    @Autowired
    private UserSystemProperties userSystemProperties;

    @ApiOperation(value = "查询所有项目")
    @GetMapping(value = "getAll")
    public ResponseNormal<List<SysProject>> getAll() {
        List<SysProject> sysProjects = sysProjectRepository.findAll();
        return ResponseUtils.getData(true, sysProjects);
    }

    @ApiOperation(value = "查询所有分支")
    @GetMapping(value = "getAllBranch")
    public ResponseNormal<List<String>> getAllBranch() throws Exception {

        String[] cmds = new String[]{
                "/bin/sh",
                "-c",
                "cd " + userSystemProperties.getProjectWorkspace(),
                "git branch -v > FILE"};
        Process process = Runtime.getRuntime().exec(cmds);
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = input.readLine()) != null) {
            System.out.println(line);
            List<String> splits = Arrays.asList(line.split("\\s+"));
            if (!CollectionUtils.isEmpty(splits) && splits.get(0).equals("*")) {
                System.out.println(line);
                break;
            }
        }
        List<String> branchs = new ArrayList<>();
        branchs.add("master");
        branchs.add("feature/WECHAT-20180321");
        branchs.add("feature/FAST-RUN-BOOT");
        return ResponseUtils.getData(true, branchs);
    }

    @ApiOperation(value = "新增一个项目")
    @PostMapping(value = "addNewSysProject")
    public ResponseNormal<String> addNewSysProject(@RequestBody SysProjectAddReq sysProjectAddReq) {
        SysProject sysProject = new SysProject();
        BeanUtils.copyProperties(sysProjectAddReq, sysProject);
        AssertUtils.isNotEmpty(LOGGER, sysProject.getName(), ResponseCommonEnum.PARAM_ERROR);
        List<SysProject> sysProjects = sysProjectRepository.queryByNameIs(sysProject.getName());
        if (!CollectionUtils.isEmpty(sysProjects)) {
            return ResponseUtils.getData(false, "操作失败，该项目已存在");
        }
        sysProject.setId(IdWorkerUtils.getId());
        sysProject.setCreateTime(new Date());
        sysProjectRepository.save(sysProject);
        return ResponseUtils.getData(true, "操作成功");
    }


}
