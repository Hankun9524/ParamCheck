package com.hankun.request.parameters.core;


import com.hankun.request.parameters.annotation.ParamAliasName;
import com.hankun.request.parameters.annotation.ParamInputType;
import com.hankun.request.parameters.annotation.ParamLength;
import com.hankun.request.parameters.cache.CheckTypeCache;
import com.hankun.request.parameters.cache.ParametersCache;
import com.hankun.request.parameters.model.FieldAttribute;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 拆解参数的核心
 *
 * @author Hankun
 */
class ReflexClassCore {

    /**
     * 对类的参数进行解析和存储
     *
     * @param cls 检测类
     */
    static List<FieldAttribute> resolveAnnotation(Class<?> cls) {

        // 先获取所有类的字段
        Map<String, Field> fieldMap = ReflexFieldCore.getField(cls);
        // 存放属性的字段
        ArrayList<FieldAttribute> fieldAttributeList = new ArrayList<>();
        // 循环遍历所有的字段
        for (String fieldKey : fieldMap.keySet()) {
            Field field = fieldMap.get(fieldKey);
            field.setAccessible(true);

            // 获取其上的注解
            Annotation[] annotationArray = field.getAnnotations();
            if (annotationArray == null || annotationArray.length == 0) {
                continue;
            }
            // 生成注解模型
            FieldAttribute attribute = new FieldAttribute();
            //判断是否有注解添加，如果没有需要进行检测的注解，可以忽略，提高运行速度
            boolean flag = false;
            for (Annotation annotation : annotationArray) {
                // 判断几种注解的类型是否是需要进行判断的
                int checkModel = CheckTypeCache.getCheckModel(annotation.annotationType().getSimpleName());
                switch (checkModel) {
                    case CheckTypeCache.TYPE_NOT_NULL:
                        flag = true;
                        attribute.setCheckEmpty(true);
                        break;
                    case CheckTypeCache.TYPE_LENGTH:
                        flag = true;
                        ParamLength paramLength = (ParamLength) annotation;
                        attribute.setCheckLength(true);
                        attribute.setLengthModel(paramLength.lengthModel());
                        attribute.setLength(paramLength.value());
                        break;
                    case CheckTypeCache.TYPE_INPUT:
                        flag = true;
                        ParamInputType paramInputType = (ParamInputType) annotation;
                        attribute.setCheckType(true);
                        attribute.setInputType(paramInputType.inputType());
                        break;
                    case CheckTypeCache.TYPE_ALIAS_NAME:
                        flag = true;
                        ParamAliasName paramAliasName = (ParamAliasName) annotation;
                        attribute.setAlias(paramAliasName.aliasName());
                        break;
                    case CheckTypeCache.TYPE_CHECK_OBJECT:
                        //需要根据当前属性的类型，判断是对象还是集合，如果是集合，则需要对集合的泛型进行检测判定。如果是对象，直接对对象的属性进行盘点给
                        flag = true;
                        attribute.setCheckObject(true);
                        break;
                    default:
                        break;
                }
            }
            //有对应的注解解析，进行添加。否则进行忽略
            if (flag) {
                attribute.setField(field);
                fieldAttributeList.add(attribute);
            }
        }
        // 存储本次解析的对象属性，用于下一步进行缓存快速的读取
        ParametersCache.putClassFiledAttribute(cls.getName(), fieldAttributeList);
        return fieldAttributeList;
    }

}
