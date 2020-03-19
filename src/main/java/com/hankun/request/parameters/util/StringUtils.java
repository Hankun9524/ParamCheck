package com.hankun.request.parameters.util;

public class StringUtils {

	
	/**
	 * 字符串的空检测
	 * 
	 * @param s 字符串
	 * @return  如果为null或者长度为0返回true  否则返回false
	 */
	public static boolean  isEmpty(String s){
		if (s == null || s.length() == 0) {
			return true;	
		}else{
			return false;	
		}
	}
	
	
}
