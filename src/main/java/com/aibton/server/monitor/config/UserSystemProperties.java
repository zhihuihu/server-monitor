/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/4/4 9:22 huzhihui Exp $$
 */
@Configuration
@ConfigurationProperties(prefix = "user.system")
public class UserSystemProperties {

    /**
     * 系统项目工作文件夹
     */
    private String projectWorkspace;

    /**
     * 是否打开权限认证
     */
    private boolean openUrlAuth;

    public String getProjectWorkspace() {
        return projectWorkspace;
    }

    public void setProjectWorkspace(String projectWorkspace) {
        this.projectWorkspace = projectWorkspace;
    }

    public boolean getOpenUrlAuth() {
        return openUrlAuth;
    }

    public void setOpenUrlAuth(boolean openUrlAuth) {
        this.openUrlAuth = openUrlAuth;
    }
}
