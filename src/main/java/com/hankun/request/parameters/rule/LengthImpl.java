package com.hankun.request.parameters.rule;

import com.hankun.request.parameters.model.FieldAttribute;
import com.hankun.request.parameters.util.ParamTypeUtil;

/**
 * 长度检测
 *
 * @author Hankun
 */
public class LengthImpl implements CheckRuleInterface {

    @Override
    public boolean check(Object fieldValue, FieldAttribute attr) {
        //如果为null,则一定不会超出长度
        if (fieldValue == null) {
            return true;
        }
        String type = getFieldType(attr.getField());
        // 只有String 类型的才需要检测长度，其他基本类型都会有默认值，对象类型的不需要检测长度
        if (type.equals(ParamTypeUtil.STRING)) {
            try {
                String value = (String) fieldValue;
                switch (attr.getLengthModel()) {
                    case Max:
                        return value.length() <= attr.getLength()[0];
                    case Min:
                        return value.length() >= attr.getLength()[0];
                    case Equal:
                        return value.length() == attr.getLength()[0];
                    case Region:
                        return value.length() >= attr.getLength()[0] && value.length() <= attr.getLength()[1];
                    default:
                        return false;
                }
            } catch (Exception e) {
                System.out.println("未设置检测区域值");
            }
            return false;
        } else {
            return true;
        }
    }
}
