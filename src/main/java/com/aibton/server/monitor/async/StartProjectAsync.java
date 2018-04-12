/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.async;

import com.aibton.framework.util.LoggerUtils;
import com.aibton.server.monitor.core.utils.IdWorkerUtils;
import com.aibton.server.monitor.dao.StartRecordRepository;
import com.aibton.server.monitor.dao.SysProjectRepository;
import com.aibton.server.monitor.data.request.RunProjectReq;
import com.aibton.server.monitor.entity.StartRecord;
import com.aibton.server.monitor.entity.SysProject;
import com.aibton.server.monitor.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/4/12 16:45 huzhihui Exp $$
 */
@Service
public class StartProjectAsync {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartProjectAsync.class);

    @Autowired
    private StartRecordRepository startRecordRepository;
    @Autowired
    private SysProjectRepository sysProjectRepository;

    @Async
    public void asyncStartProject(RunProjectReq runProjectReq, SysUser loginSysUser) throws Exception {
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
        String cmd = "sh /usr/local/java/sh/auto-publish/cc-start.sh " + sysProject.getName() + " " + runProjectReq.getBranch() + " " + sysProject.getPidSearchValue()
                + " " + sysProject.getBuildFolder() + " " + sysProject.getDeployProjectFolderName() + " " + sysProject.getDeployFolder()
                + " " + sysProject.getStartCmdFolder() + " " + sysProject.getOpenConnectUrl();
        System.out.println(cmd);
        String[] cmds = new String[]{
                "/bin/sh",
                "-c",
                cmd
        };
        LoggerUtils.info(LOGGER, "----执行开始");
        process = Runtime.getRuntime().exec(cmd);
        if (process.waitFor() != 0) {
            LoggerUtils.info(LOGGER, "----执行失败");
        } else {
            LoggerUtils.error(LOGGER, "----执行成功");
        }
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = input.readLine()) != null) {
            List<String> splits = Arrays.asList(line.split("\\s+"));
            System.out.println(line);
        }
    }

}
