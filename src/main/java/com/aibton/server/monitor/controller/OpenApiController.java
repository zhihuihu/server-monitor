/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/4/9 17:19 huzhihui Exp $$
 */
@Api(description = "开放接口")
@Controller
@RequestMapping(value = "openApi")
public class OpenApiController {

    @RequestMapping(value = "test")
    public String test(HttpServletResponse response) {
        Cookie cookie = new Cookie("voucher", "ozD9_xKCmxWLJCo0p5N4JiS_veP0");
        cookie.setMaxAge(30 * 60);// 设置为30min
        cookie.setDomain("hxkj.com");
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:http://server.hxkj.com";
    }

    @ApiOperation(value = "获得sessionId")
    @GetMapping(value = "getSessionId")
    @ResponseBody
    public String getSessionId(HttpServletRequest request) {
        System.out.println(request.getSession().getId());
        return request.getSession().getId();
    }
}
