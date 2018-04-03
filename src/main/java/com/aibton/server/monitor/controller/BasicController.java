/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.controller;

import com.aibton.framework.data.ResponseNormal;
import com.aibton.framework.util.ResponseUtils;
import com.aibton.framework.util.TimeUtils;
import com.aibton.server.monitor.data.response.SysInfoResp;
import com.aibton.server.monitor.data.response.system.OperatorResp;
import com.aibton.server.monitor.data.response.system.ProjectStatusResp;
import com.aibton.server.monitor.data.response.system.UsageResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 14:55 huzhihui Exp $$
 */
@Api(description = "基本状态相关接口")
@RestController
public class BasicController {

    @ApiOperation(value = "系统基本情况")
    @GetMapping(value = "system/info")
    public ResponseNormal<SysInfoResp> sysInfo() throws Exception {
        SysInfoResp sysInfoResp = new SysInfoResp();
        Process process = Runtime.getRuntime().exec("free -m");
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        String totalMem = "";
        String useMem = "";
        while ((line = input.readLine()) != null) {
            List<String> splits = Arrays.asList(line.split("\\s+"));
            if (!CollectionUtils.isEmpty(splits) && splits.get(0).equals("Mem:")) {
                totalMem = splits.get(1);
                useMem = splits.get(2);
                break;
            }
        }
        UsageResp mem = new UsageResp();
        mem.setName("内存");
        mem.setPercent((Double.parseDouble(useMem) / Double.parseDouble(totalMem)) + "");
        mem.setTotal(totalMem + "M");

        process = Runtime.getRuntime().exec("top -bn 1 -i -c");
        input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String cpuUse = "";
        while ((line = input.readLine()) != null) {
            List<String> splits = Arrays.asList(line.split("\\s+"));
            if (!CollectionUtils.isEmpty(splits) && splits.get(0).equals("%Cpu(s):")) {
                cpuUse = splits.get(1);
                break;
            }
        }

        UsageResp cpu = new UsageResp();
        cpu.setName("CPU");
        cpu.setPercent(cpuUse);
        cpu.setTotal("3.5GHz");
        OperatorResp operatorResp = new OperatorResp();
        operatorResp.setName("cqq");
        operatorResp.setBranch("master");
        operatorResp.setTime(new Date());

        sysInfoResp.setMemory(mem);
        sysInfoResp.setCpu(cpu);
        sysInfoResp.setOperator(operatorResp);

        return ResponseUtils.getData(true, sysInfoResp);
    }

    @ApiOperation(value = "系统运行项目基本情况")
    @GetMapping(value = "system/projectStatus")
    public ResponseNormal<List<ProjectStatusResp>> projectStatus() {
        List<ProjectStatusResp> projectStatusResps = new ArrayList<>();
        ProjectStatusResp cos = new ProjectStatusResp();
        cos.setName("COS");
        cos.setBranch("master");
        cos.setStatus("运行中");
        cos.setOperateName("胡志辉");
        cos.setOperateTime(TimeUtils.getNowTime());
        ProjectStatusResp sms = new ProjectStatusResp();
        BeanUtils.copyProperties(cos, sms);
        sms.setName("SMS");
        sms.setStatus("未运行");

        projectStatusResps.add(cos);
        projectStatusResps.add(sms);
        return ResponseUtils.getData(true, projectStatusResps);
    }
}
