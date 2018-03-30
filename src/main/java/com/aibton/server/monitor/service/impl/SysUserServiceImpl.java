/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.service.impl;

import com.aibton.framework.data.ResponseNormal;
import com.aibton.framework.util.AssertUtils;
import com.aibton.framework.util.ResponseUtils;
import com.aibton.server.monitor.core.enums.ResponseCommonEnum;
import com.aibton.server.monitor.core.utils.IdWorkerUtils;
import com.aibton.server.monitor.core.utils.SessionUtils;
import com.aibton.server.monitor.dao.SysUserRepository;
import com.aibton.server.monitor.entity.SysUser;
import com.aibton.server.monitor.service.inter.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 14:38 huzhihui Exp $$
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public ResponseNormal login(SysUser sysUser) {
        AssertUtils.isNotNull(LOGGER, sysUser, ResponseCommonEnum.PARAM_ERROR);
        AssertUtils.isNotEmpty(LOGGER, sysUser.getName(), ResponseCommonEnum.PARAM_ERROR);
        AssertUtils.isNotEmpty(LOGGER, sysUser.getPost(), ResponseCommonEnum.PARAM_ERROR);
        List<SysUser> sysUsers = sysUserRepository.findByNameIsAndPostIs(sysUser.getName(), sysUser.getPost());
        if (CollectionUtils.isEmpty(sysUsers)) {
            sysUser.setId(IdWorkerUtils.getId());
            sysUser.setCreateTime(new Date());
            sysUser.setLoginTime(new Date());
            sysUserRepository.save(sysUser);
        } else {
            SysUser sysUserLogin = sysUsers.get(0);
            sysUserLogin.setLoginTime(new Date());
            sysUserRepository.save(sysUserLogin);
        }
        SessionUtils.setLoginUserInfo(sysUser);
        return ResponseUtils.getData(true, "操作成功，用户登录成功");
    }
}
