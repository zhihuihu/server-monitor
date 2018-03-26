/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.aibton.server.monitor.core.utils;

import com.aibton.framework.util.ExceptionUtils;
import com.aibton.framework.util.JackSonUtils;
import com.aibton.framework.util.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * HttpServletResponse 工具类
 *
 * @author huzhihui
 * @version $: v 0.1 2017 2017/12/24 11:14 huzhihui Exp $$
 */
public class HttpServletResponseJsonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpServletResponseJsonUtils.class);

    /**
     * 返回json对象到前端
     *
     * @param response
     * @param object
     */
    public static void sendJsonObject(HttpServletResponse response, Object object) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(JackSonUtils.objectToJsonStr(object));
        } catch (Exception ex) {
            LoggerUtils.error(LOGGER, "HttpServletResponse 返回JSON失败，error={0}", ExceptionUtils.getExceptionString(ex));
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
