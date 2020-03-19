package com.hankun.request.parameters.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 长度检测
 *
 * @author HanKun
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ParamInputType {

	
	/**
	 * 输入类型检测
	 * 
	 * @return 检测模式
	 */
	InputType  inputType() default InputType.Text;
	
}
