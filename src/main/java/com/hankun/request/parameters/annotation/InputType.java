package com.hankun.request.parameters.annotation;

/**
 * 输入类型的限定
 * 
 * @author Hankun
 *
 */
public enum InputType {
	
	/**
	 * 文本
	 */
	Text,
	/**
	 * 标准日期
	 */
	Date,
	/**
	 * 数字，整数类型
	 */
	Number,
	
	/**
	 * 数字，可以包含浮点型数字
	 */
	NumberDecimal,
	
	/**
	 * 手机号码，11位
	 */
	MobilePhone,
	
	/**
	 * 密码类型，数字和字母
	 */
	Password,
	
	/**
	 * 电子邮箱
	 * 
	 */
	Email,
	/**
	 * 网页地址
	 */
	Url,
	
	/**
	 * 身份证号码
	 */
	IdNumber
	

}
