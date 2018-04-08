package com.aibton.server.monitor.interceptor;

import java.lang.annotation.*;

/**
 * 权限认证注解
 *
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/23 13:25 huzhihui Exp $$
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UrlAuth {

    /**
     * 权限需要类型
     *
     * @return
     */
    UrlAuthTypeEnum value() default UrlAuthTypeEnum.NEED_LOGIN;
}
