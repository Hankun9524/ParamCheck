package com.hankun.request.parameters.rule;

import com.hankun.request.parameters.model.FieldAttribute;
import com.hankun.request.parameters.util.ParamTypeUtil;
import com.hankun.request.parameters.util.StringUtils;

/**
 * 非空检测
 *
 * @author Hankun
 */
public class NotNullImpl implements CheckRuleInterface {

    @Override
    public boolean check(Object fieldValue, FieldAttribute attr) {
        if (fieldValue == null) {
            return false;
        } else {
            String type = getFieldType(attr.getField());
            // 只有String 类型的才需要检测长度，其他基本类型都会有默认值，对象类型的检测不为空即可
            switch (type) {
                case ParamTypeUtil.CHAR:
                    return !StringUtils.isEmpty(String.valueOf((char) fieldValue));
                case ParamTypeUtil.STRING:
                    return !StringUtils.isEmpty((String) fieldValue);
                default:
                    return true;
            }
        }

    }

}
