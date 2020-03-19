package com.hankun.request.parameters.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hankun.request.parameters.model.FieldAttribute;

/**
 * 
 * 缓存需要进行检测的类型属性，缓存可以极大的提高运行速度
 * 
 * @author Hankun
 *
 */
public class ParametersCache {

	/**
	 * 
	 * 缓存反射属性和对象
	 * 
	 * key  类名全名
	 * 
	 * value 储存的需要校验的属性
	 * 
	 */
	private static Map<String, List<FieldAttribute>> classCache = new HashMap<String, List<FieldAttribute>>();

	/**
	 * 
	 * 存储一个类的检测类型
	 * 
	 * @param className
	 *            类的全名，用来存储方便获取类的属性
	 * @param fieldList
	 *            注解属性，需要检测的属性
	 */
	public static void putClassFiledAttribute(String className,List<FieldAttribute> fieldList) {
		classCache.put(className, fieldList);
	}

	/**
	 * 获取一个类的注解检测字段
	 * 
	 * @param className
	 *            类的全路径
	 * @return 返回类的检测属性，如果没有，返回null
	 */
	public static List<FieldAttribute> getClassFiledAttribute(String className) {
		if (classCache.containsKey(className)) {
			return classCache.get(className);
		} else {
			return null;
		}
	}

}
