/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.data.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/30 11:59 huzhihui Exp $$
 */
@ApiModel
public class SysProjectAddReq {

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "项目具体值")
    private String value;

    @ApiModelProperty(value = "pid搜索值")
    private String pidSearchValue;

    @ApiModelProperty(value = "项目总文件夹")
    private String homeProjectFolder;

    @ApiModelProperty(value = "编译后文件夹")
    private String buildFolder;

    @ApiModelProperty(value = "发布的文件夹")
    private String deployFolder;

    @ApiModelProperty(value = "发布项目文件夹名称")
    private String deployProjectFolderName;

    @ApiModelProperty(value = "测试连接URL")
    private String openConnectUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPidSearchValue() {
        return pidSearchValue;
    }

    public void setPidSearchValue(String pidSearchValue) {
        this.pidSearchValue = pidSearchValue;
    }

    public String getHomeProjectFolder() {
        return homeProjectFolder;
    }

    public void setHomeProjectFolder(String homeProjectFolder) {
        this.homeProjectFolder = homeProjectFolder;
    }

    public String getBuildFolder() {
        return buildFolder;
    }

    public void setBuildFolder(String buildFolder) {
        this.buildFolder = buildFolder;
    }

    public String getDeployFolder() {
        return deployFolder;
    }

    public void setDeployFolder(String deployFolder) {
        this.deployFolder = deployFolder;
    }

    public String getDeployProjectFolderName() {
        return deployProjectFolderName;
    }

    public void setDeployProjectFolderName(String deployProjectFolderName) {
        this.deployProjectFolderName = deployProjectFolderName;
    }

    public String getOpenConnectUrl() {
        return openConnectUrl;
    }

    public void setOpenConnectUrl(String openConnectUrl) {
        this.openConnectUrl = openConnectUrl;
    }
}
