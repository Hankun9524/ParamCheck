package com.hankun.request.parameters.rule;

import java.util.regex.Pattern;

import com.hankun.request.parameters.model.FieldAttribute;
import com.hankun.request.parameters.util.ParamTypeUtil;

/**
 * 双精度类型的数字验证
 *
 * @author Hankun
 */
public class NumberDecimalInputImpl implements CheckRuleInterface {

    /**
     * 数字浮点类型
     */
    private final String rule = "-?([1-9]\\d*.\\d*|0\\.\\d*[1-9]\\d*)";

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
            case ParamTypeUtil.FLOAT:
            case ParamTypeUtil.DOUBLE:
                return true;
            default:
                return false;
        }
    }

}
