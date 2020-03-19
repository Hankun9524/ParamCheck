package com.hankun.request.parameters.rule;



import com.hankun.request.parameters.model.FieldAttribute;
import com.hankun.request.parameters.util.IdentityUtils;
import com.hankun.request.parameters.util.ParamTypeUtil;


/**
 * 
 * 身份证号码验证
 *
 * @author Hankun
 *
 */
public class IDNumberInputImpl implements CheckRuleInterface {
	


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
			String idNum = (String) fieldValue;
			return IdentityUtils.isLegalPattern(idNum);
		} else {
			return false;
		}
	}
	


}
