/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.controller;

import com.aibton.framework.data.ResponseNormal;
import com.aibton.framework.util.AssertUtils;
import com.aibton.framework.util.ResponseUtils;
import com.aibton.server.monitor.core.enums.ResponseCommonEnum;
import com.aibton.server.monitor.core.utils.IdWorkerUtils;
import com.aibton.server.monitor.dao.SysProjectRepository;
import com.aibton.server.monitor.entity.SysProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 18:37 huzhihui Exp $$
 */
@RestController
@RequestMapping(value = "sysProject")
public class SysProjectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysProjectController.class);

    @Autowired
    private SysProjectRepository sysProjectRepository;

    /**
     * 新增一个项目
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "addNewSysProject")
    public ResponseNormal addNewSysProject(String name) {
        AssertUtils.isNotEmpty(LOGGER, name, ResponseCommonEnum.PARAM_ERROR);
        List<SysProject> sysProjects = sysProjectRepository.queryByNameIs(name);
        if (!CollectionUtils.isEmpty(sysProjects)) {
            return ResponseUtils.getData(false, "操作失败，该项目已存在");
        }
        SysProject sysProject = new SysProject();
        sysProject.setId(IdWorkerUtils.getId());
        sysProject.setName(name);
        sysProject.setCreateTime(new Date());
        sysProjectRepository.save(sysProject);
        return ResponseUtils.getData(true, "操作成功");
    }
}
