package com.hankun.request.parameters.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * 输入类型的检测，加入此检测的字段会根据需要的类型去匹配，看是否是匹配的格式
 * 
 * @author Hankun
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ParamNotNull {
}
