package com.hankun.request.parameters.rule;

import java.util.regex.Pattern;

import com.hankun.request.parameters.model.FieldAttribute;
import com.hankun.request.parameters.util.ParamTypeUtil;

/**
 * 数字类型的检测
 *
 * @author Hankun
 */
public class NumberInputImpl implements CheckRuleInterface {

    /**
     * 数字类型正则
     */
    private final String rule = "-?[0-9]\\d*";

    /**
     * 正则
     */
    private Pattern pattern = Pattern.compile(rule);

    @Override
    public boolean check(Object fieldValue, FieldAttribute attr) {
        // 如果为null,则一定不会超出长度
        if (fieldValue == null) {
            return false;
        }
        String type = getFieldType(attr.getField());
        // 只有String 类型的才需要检测长度，其他基本类型都会有默认值，对象类型的不需要检测长度
        switch (type) {
            case ParamTypeUtil.STRING: {
                String number = (String) fieldValue;
                return pattern.matcher(number).matches();
            }
            case ParamTypeUtil.BYTE:
            case ParamTypeUtil.INT:
            case ParamTypeUtil.CHAR:
            case ParamTypeUtil.LONG:
            case ParamTypeUtil.SHORT:
                return true;
            default:
                return false;
        }
    }
}
