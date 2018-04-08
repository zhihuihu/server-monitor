/**
 * otoc.cn ltd.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.aibton.server.monitor.interceptor;

import com.aibton.framework.exception.ExtItemException;
import com.aibton.server.monitor.core.enums.ResponseCommonEnum;
import com.aibton.server.monitor.core.utils.SessionUtils;
import com.aibton.server.monitor.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 权限认证拦截器
 *
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/23 13:28 huzhihui Exp $$
 */
@Component
public class UrlAuthInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlAuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        SysUser loginSysUser = SessionUtils.getLoginUserInfo();
        if (o instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) o;
            UrlAuth urlAuth = handlerMethod.getMethodAnnotation(UrlAuth.class);
            if (null != urlAuth) {
                UrlAuthTypeEnum value = urlAuth.value();
                if (value.equals(UrlAuthTypeEnum.NEED_LOGIN) && null == loginSysUser) {
                    throw new ExtItemException(ResponseCommonEnum.NOT_LOGIN);
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    /**
     * 获取请求格式化参数
     *
     * @param httpServletRequest
     * @return
     */
    private String getRequestQueryString(HttpServletRequest httpServletRequest) {
        String queryString = "";
        Map<String, String[]> params = httpServletRequest.getParameterMap();
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }
        if (!org.springframework.util.StringUtils.isEmpty(queryString)) {
            queryString = queryString.substring(0, queryString.length() - 1);
        }
        return queryString;
    }
}
