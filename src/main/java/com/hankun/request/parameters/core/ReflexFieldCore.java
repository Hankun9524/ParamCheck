package com.hankun.request.parameters.core;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射辅助类
 *
 * @author Hankun
 */
public class ReflexFieldCore {

    /**
     * 解析字段
     *
     * @param cls 检测类
     * @return 字段映射
     */
    public static Map<String, Field> getField(Class<?> cls) {
        Map<String, Field> fieldMap = new HashMap<>();
        Field[] fields = cls.getDeclaredFields();
        String name;
        for (Field field : fields) {
            name = field.getName();
            fieldMap.put(name, field);
        }
        Class<?> tempSuper = cls.getSuperclass();
        while (tempSuper.getName() .equals(Object.class.getName()) ) {
            fieldMap.putAll(getField(cls.getSuperclass()));
            tempSuper = tempSuper.getSuperclass();
        }
        return fieldMap;
    }

    /**
     * 获取对象一个字段的值
     *
     * @param obj   对象
     * @param field 方法
     * @return 设置的值
     */
    public static Object getFieldValue(Object obj, Field field) {
        try {
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
