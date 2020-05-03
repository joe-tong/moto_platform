package com.tulin.common.utlis;

import java.util.Collection;
import java.util.Map;

/**
 * 为空判断
 *
 * @author tpp
 * @date 2018/7/17
 */
public class BlankUtil {

    /**
     * 判断collection是否为空
     *
     * @param collection
     * @return
     */
    public static boolean isBlank(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    /**
     * 判断map是否为空
     *
     * @param map
     * @return
     */
    public static boolean isBlank(Map map) {
        return map == null || map.size() == 0;
    }

    /**
     * 判断数组是否为空
     *
     * @param objects 数组
     * @return
     */
    public static boolean isBlank(Object[] objects) {
        return objects == null || objects.length == 0;
    }

    /**
     * 判断字符串是否为空
     *
     * @param string 字符串
     * @return
     */
    public static boolean isBlank(String string) {
        return string == null || string.length() == 0;
    }


}
