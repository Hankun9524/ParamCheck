package com.hankun.request.parameters.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要对子对象进行检测，可以用在自定义的数据模型对象等等进行检测，数组需要检测内容的也可以进行检查
 * String类型作为基础类型进行检查，不需要进行此标记
 * 可对 List ArrayList LinkedList进行检测
 * Map只支持Map HashMap集合，并且只会对value进行检测，要求value必须是注解类型的对象才可以进行检测
 *
 * @author Hankun
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ParamCheckObject {
}
