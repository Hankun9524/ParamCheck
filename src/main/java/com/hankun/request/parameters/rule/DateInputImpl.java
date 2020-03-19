package com.hankun.request.parameters.rule;

import java.util.regex.Pattern;

import com.hankun.request.parameters.model.FieldAttribute;
import com.hankun.request.parameters.util.ParamTypeUtil;

/**
 * 
 * 日期的检测 yyyy
 * 
 * @author Hankun
 *
 */
public class DateInputImpl implements CheckRuleInterface{

	/**
	 * 
	 * 标准日期检测
	 * 
	 */
	private final String rule = "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}";

	/**
	 * 正则过滤邮箱
	 */
	private Pattern pattern = Pattern.compile(rule);

	@Override
	public boolean check(Object fieldValue, FieldAttribute attr) {
		// 必须是字符串类型的才有效
		// 如果为null,则一定不会超出长度
		if (fieldValue == null) {
			return false;
		}
		String type = getFieldType(attr.getField());
		// 只有String 类型的才需要检测长度，其他基本类型都会有默认值，对象类型的不需要检测长度
		if (type.equals(ParamTypeUtil.STRING)) {
			String date = (String) fieldValue;
			return pattern.matcher(date).matches();
		} else {
			return false;
		}
	}

}
