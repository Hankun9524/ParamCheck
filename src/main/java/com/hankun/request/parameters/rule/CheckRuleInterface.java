package com.hankun.request.parameters.rule;

import java.lang.reflect.Field;

import com.hankun.request.parameters.model.FieldAttribute;

/**
 * 字段检测的规则
 *
 * @author Hankun
 */
public interface CheckRuleInterface {


    /**
     * 检测字段值是否匹配类型
     *
     * @param fieldValue 字段值
     * @param attr       解析的注解属性对象
     * @return 是否检测通过
     */
    boolean check(Object fieldValue, FieldAttribute attr);


    /**
     * 获取字段的类型
     *
     * @param field 属性字段
     * @return 获取字段的类型
     */
    default String getFieldType(Field field) {
        String type = field.getType().getName();
        return type;
    }


}
