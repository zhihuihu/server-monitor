/**
 * Aibton.com Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.aibton.server.monitor.config.exception;

import com.aibton.framework.exception.AbstractExceptionHandler;
import com.aibton.server.monitor.core.utils.HttpServletResponseJsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 *
 * @author huzhihui
 * @version $: v 0.1 2017 2017/9/23 15:12 huzhihui Exp $$
 */
@ControllerAdvice
public class GlobalException extends AbstractExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalException.class);

    @Override
    public Object errorHandler(HttpServletRequest request, Exception e) {
        return null;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            HttpServletResponseJsonUtils.sendJsonObject(response, this.errorHandlerProcess(request, ex));
            return null;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/basical/page/error");
            return modelAndView;
        }
    }

}
