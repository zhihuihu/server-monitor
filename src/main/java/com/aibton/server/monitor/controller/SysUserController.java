/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.controller;

import com.aibton.framework.data.ResponseNormal;
import com.aibton.framework.util.ResponseUtils;
import com.aibton.server.monitor.core.utils.SessionUtils;
import com.aibton.server.monitor.data.request.LoginReq;
import com.aibton.server.monitor.entity.SysUser;
import com.aibton.server.monitor.service.inter.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 14:54 huzhihui Exp $$
 */
@Api(description = "用户相关接口")
@RestController
@RequestMapping(value = "sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "login")
    public ResponseNormal<String> login(@RequestBody LoginReq loginReq) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(loginReq, sysUser);
        return sysUserService.login(sysUser);
    }

    @ApiOperation(value = "获取登录用户信息")
    @GetMapping(value = "loginUserInfo")
    public ResponseNormal<SysUser> loginUserInfo() {
        return ResponseUtils.getData(true, SessionUtils.getLoginUserInfo());
    }

}
