package com.aibton.server.monitor.core.enums;

import com.aibton.framework.enums.inter.IEnum;

/**
 * 普通返回枚举
 *
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 16:24 huzhihui Exp $$
 */
public enum ResponseCommonEnum implements IEnum<String, String, String> {

    /**
     * 操作失败，参数错误
     */
    PARAM_ERROR("000000", "操作失败，参数错误", null),

    /**
     * 操作失败，未登录系统
     */
    NOT_LOGIN("200000", "操作失败，未登录系统", null),;

    private String code;

    private String value;

    private String group;

    ResponseCommonEnum(String code, String value, String group) {
        this.code = code;
        this.value = value;
        this.group = group;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    public static String getCode(String value, String group) {
        for (ResponseCommonEnum e : ResponseCommonEnum.values()) {
            if (e.getValue().equals(value) && e.getGroup().equals(group)) {
                return e.code;
            }
        }
        return null;
    }

    public static String getValue(String code, String group) {
        for (ResponseCommonEnum e : ResponseCommonEnum.values()) {
            if (e.getCode().equals(code) && e.getGroup().equals(group)) {
                return e.value;
            }
        }
        return null;
    }
}
