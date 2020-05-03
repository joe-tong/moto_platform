package com.tulin.platform_system.config;


import com.tulin.common.base.enumeration.BaseEnum;
import com.tulin.common.base.enumeration.ResponseCode;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 童平平
 * @Description: swagger首页，这里是显示枚举说明部分
 */
public class SwaggerInfo {
    private static final long serialVersionUID = 1L;


    /***
     * 解析枚举类型，并形成文档说明格式
     * @param enumType
     * @param <T>
     * @return
     */
    private static <T extends BaseEnum<?>> String parse(Class<T> enumType) {
        StringBuilder sb = new StringBuilder("<p>");
        T[] enums = enumType.getEnumConstants();
        for (T t : enums) {
            try {
                sb.append("" + t.code() + "=" + MethodUtils.invokeMethod(t, "name")).append("<br/>");
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        sb.setLength(sb.length() - 1);
        sb.append("</p>");
        return sb.toString();
    }

    public static String init(String descTitle) {
        StringBuilder desc = new StringBuilder();
        desc.append(descTitle);
        desc.append(parse(ResponseCode.class));
        return desc.toString();
    }
}
