/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.config;

import com.aibton.server.monitor.interceptor.UrlAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/4/12 11:22 huzhihui Exp $$
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private UrlAuthInterceptor urlAuthInterceptor;
    @Autowired
    private UserSystemProperties userSystemProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (userSystemProperties.getOpenUrlAuth()) {
            //这里全部拦截都可以，只要不放权限注解
            registry.addInterceptor(urlAuthInterceptor).addPathPatterns("/**").excludePathPatterns("/", "");
        }
    }
}
