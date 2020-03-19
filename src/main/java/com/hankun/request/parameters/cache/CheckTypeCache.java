package com.hankun.request.parameters.cache;

import java.util.HashMap;
import java.util.Map;

import com.hankun.request.parameters.annotation.ParamAliasName;
import com.hankun.request.parameters.annotation.ParamCheckObject;
import com.hankun.request.parameters.annotation.ParamInputType;
import com.hankun.request.parameters.annotation.ParamLength;
import com.hankun.request.parameters.annotation.ParamNotNull;


public class CheckTypeCache {


    private static Map<String, Integer> typeMap = new HashMap();


    public static final int TYPE_UNKNOW = -0x00001;

    /**
     * 不为空的标记
     */
    public static final int TYPE_NOT_NULL = 0x00000;


    /**
     * 别名检测标记
     */
    public static final int TYPE_ALIAS_NAME = 0x00001;


    /**
     * 输入类型的检测，必须标记的是String类型
     */
    public static final int TYPE_INPUT = 0x00002;


    /**
     * 长度的检测
     */
    public static final int TYPE_LENGTH = 0x00003;


    /**
     * 属性为对象时，需要对这个属性对象的内容也进行检测
     */
    public static final int TYPE_CHECK_OBJECT = 0x00004;


    static {
        typeMap.put(ParamNotNull.class.getSimpleName(), TYPE_NOT_NULL);
        typeMap.put(ParamAliasName.class.getSimpleName(), TYPE_ALIAS_NAME);
        typeMap.put(ParamInputType.class.getSimpleName(), TYPE_INPUT);
        typeMap.put(ParamLength.class.getSimpleName(), TYPE_LENGTH);
        typeMap.put(ParamCheckObject.class.getSimpleName(), TYPE_CHECK_OBJECT);
    }


    /**
     * 根据注解名称获取检测类型
     *
     * @param clsName 名称
     * @return 返回检测类型
     */
    public static int getCheckModel(String clsName) {
        if (typeMap.containsKey(clsName)) {
            return typeMap.get(clsName);
        } else {
            return TYPE_UNKNOW;
        }
    }


}
