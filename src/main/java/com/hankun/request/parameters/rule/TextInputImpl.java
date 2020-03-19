package com.hankun.request.parameters.rule;

import com.hankun.request.parameters.model.FieldAttribute;

/**
 * 
 * 文本类型的检测，任意文本
 * 
 * @author Hankun
 *
 */
public class TextInputImpl implements CheckRuleInterface {

	@Override
	public boolean check(Object fieldValue,FieldAttribute attr) {
		return true;
	}

}
