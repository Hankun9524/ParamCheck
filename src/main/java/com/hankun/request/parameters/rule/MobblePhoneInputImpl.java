package com.hankun.request.parameters.rule;

import java.util.regex.Pattern;

import com.hankun.request.parameters.model.FieldAttribute;
import com.hankun.request.parameters.util.ParamTypeUtil;


/**
 * 手机号码的检测
 * 
 * 
 * @author Hankun
 *
 */
public class MobblePhoneInputImpl implements CheckRuleInterface{


	/**
	 * 
	 * 手机号码类型的正则
	 * 
	 */
	private final String rule = "0?(13|14|15|16|18|17|19)[0-9]{9}";

	/**
	 * 正则
	 */
	private Pattern pattern = Pattern.compile(rule);

	@Override
	public boolean check(Object fieldValue,FieldAttribute attr) {
		//密码类型必须是字符串类型，必须是数字或者字母，不允许包含特殊字符串以及汉字
		// 必须是字符串类型的才有效
		// 如果为null,则一定不会超出长度
		if (fieldValue == null) {
			return false;
		}
		String type = getFieldType(attr.getField());
		// 只有String 类型的才需要检测长度，其他基本类型都会有默认值，对象类型的不需要检测长度
		if (type.equals(ParamTypeUtil.STRING)) {
			String phone = (String) fieldValue;
			return pattern.matcher(phone).matches();
		} else {
			return false;
		}
	}


}
