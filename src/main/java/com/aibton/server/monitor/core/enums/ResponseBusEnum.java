package com.aibton.server.monitor.core.enums;

import com.aibton.framework.enums.inter.IEnum;

/**
 * 业务返回枚举
 *
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 16:24 huzhihui Exp $$
 */
public enum ResponseBusEnum implements IEnum<String, String, String> {

    /**
     * 操作成功，系统发布中
     */
    PROJECT_STARTING("000001", "操作成功，系统发布中", null),

    /**
     * 操作成功，系统发布失败
     */
    PROJECT_START_ERROR("000002", "操作成功，系统发布失败", null),

    /**
     * 操作成功，系统发布成功
     */
    PROJECT_START_SUCCESS("000003", "操作成功，系统发布成功", null),;

    private String code;

    private String value;

    private String group;

    ResponseBusEnum(String code, String value, String group) {
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
        for (ResponseBusEnum e : ResponseBusEnum.values()) {
            if (e.getValue().equals(value) && e.getGroup().equals(group)) {
                return e.code;
            }
        }
        return null;
    }

    public static String getValue(String code, String group) {
        for (ResponseBusEnum e : ResponseBusEnum.values()) {
            if (e.getCode().equals(code) && e.getGroup().equals(group)) {
                return e.value;
            }
        }
        return null;
    }
}
