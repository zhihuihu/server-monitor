package com.aibton.server.monitor.service.inter;

import com.aibton.framework.data.ResponseNormal;
import com.aibton.server.monitor.entity.SysUser;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 14:38 huzhihui Exp $$
 */
public interface SysUserService {

    /**
     * 用户登录
     *
     * @param sysUser
     * @return
     */
    ResponseNormal login(SysUser sysUser);
}
