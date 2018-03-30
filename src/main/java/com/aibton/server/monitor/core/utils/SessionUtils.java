/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.core.utils;

import com.aibton.framework.util.HttpServletRequestUtils;
import com.aibton.server.monitor.entity.SysUser;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/30 14:47 huzhihui Exp $$
 */
public class SessionUtils {

    public static void setLoginUserInfo(SysUser sysUser) {
        HttpServletRequestUtils.getHttpSession().setAttribute("loginUser", sysUser);
    }

    public static SysUser getLoginUserInfo() {
        return (SysUser) HttpServletRequestUtils.getHttpSession().getAttribute("loginUser");
    }
}
