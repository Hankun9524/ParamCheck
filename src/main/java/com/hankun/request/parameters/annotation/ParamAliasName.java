package com.hankun.request.parameters.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * 可以给字段注解一个别名，别名起到的作用可以在返回或者提醒的时候使用，会把字段的提示映射成别名
 * 
 * @author Hankun
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ParamAliasName {

	
	/**
	 * 参数别名，默认为null，不使用别名
	 * 
	 * @return 获取别名标识
	 */
	String aliasName() default "";
	
}
