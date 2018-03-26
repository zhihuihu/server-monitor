/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.controller;

import com.aibton.framework.data.ResponseNormal;
import com.aibton.server.monitor.entity.SysUser;
import com.aibton.server.monitor.service.inter.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 14:54 huzhihui Exp $$
 */
@RestController
@RequestMapping(value = "sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 登录
     *
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "login")
    public ResponseNormal login(SysUser sysUser) {
        return sysUserService.login(sysUser);
    }


}
