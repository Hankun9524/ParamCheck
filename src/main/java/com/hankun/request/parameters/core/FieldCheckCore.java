package com.hankun.request.parameters.core;

import java.util.List;
import java.util.Map;

import com.hankun.request.parameters.message.RequestCheckMessageUtils;
import com.hankun.request.parameters.model.FieldAttribute;
import com.hankun.request.parameters.model.ParamsCheckResult;
import com.hankun.request.parameters.rule.CheckRuleFactory;
import com.hankun.request.parameters.util.ParamTypeUtil;

/**
 * 字段检测的核心
 *
 * @author Hankun
 */
class FieldCheckCore {

    /**
     * 字段检测的核心，对于需要检测的每个字段进行检测
     *
     * @param obj                需要检测的对象
     * @param fieldAttributeList 需要检测的对象的字段信息
     * @return 返回检测结果
     */
    static ParamsCheckResult fieldCheck(Object obj, List<FieldAttribute> fieldAttributeList) {
        // 开始循环遍历进行数据检测
        for (FieldAttribute attribute : fieldAttributeList) {
            // 获取字段的值
            Object fieldValue = ReflexFieldCore.getFieldValue(obj, attribute.getField());
            // 先判断是否需要进行空检测
            if (attribute.isCheckEmpty()) {
                // 空检测未通过
                if (!CheckRuleFactory.getEmptyRuleImpl().check(fieldValue, attribute)) {
                    // 返回空检测字段失败
                    return RequestCheckMessageUtils.getEmptyTypeError(attribute);
                }
            }
            // 如果参数为空，并且允许为空，在这里就直接结束，可以返回状态检测通过，否则，可以为空的参数一旦填写了，就根据规则继续往下进行检测，直到整个检测过程结束
            // 这里如果能走到已经是空的，表明就是允许为空，如果是不能为空的检测，再上一步直接就会返回。
            if (fieldValue == null) {
                continue;
            }
            //判断是不是对象类型，如果是对象类型，进行对象类型的检测，不需要进行长度类型等检测
            if (attribute.isCheckObject()) {
                String fieldTypeName = attribute.getField().getType().getTypeName();
                switch (fieldTypeName) {
                    case ParamTypeUtil.BOOLEAN:
                    case ParamTypeUtil.BYTE:
                    case ParamTypeUtil.CHAR:
                    case ParamTypeUtil.DOUBLE:
                    case ParamTypeUtil.FLOAT:
                    case ParamTypeUtil.INT:
                    case ParamTypeUtil.LONG:
                    case ParamTypeUtil.STRING:
                    case ParamTypeUtil.SHORT:
                        //当是以上基本类型时，抛出错误类型的提示
                        return RequestCheckMessageUtils.getCheckTypeError(attribute);
                    case ParamTypeUtil.LIST:
                    case ParamTypeUtil.ARRAYLIST:
                    case ParamTypeUtil.LINKEDLIST:
                        //因为为空已经判断，直接进行属性值转换，获取到所有对象，进行检测
                        List list = (List) fieldValue;
                        for (Object child : list) {
                            ParamsCheckResult result = CheckCore.check(child);
                            if (!result.isSuccess()) {
                                return result;
                            }
                        }
                        break;
                    case ParamTypeUtil.MAP:
                    case ParamTypeUtil.HASHMAP:
                        //map 默认只对value进行检测
                        Map map = (Map) fieldValue;
                        for (Object value : map.values()) {
                            ParamsCheckResult result = CheckCore.check(value);
                            if (!result.isSuccess()) {
                                return result;
                            }
                        }
                        break;
                    default:
                        //对象类型，继续调用存储检测方法
                        ParamsCheckResult result = CheckCore.check(fieldValue);
                        if (!result.isSuccess()) {
                            return result;
                        }
                }
            } else {
                // 是否需要检测长度
                if (attribute.isCheckLength()) {
                    // 长度检测，检测长度是否符合要求,是否再长度范围内
                    // 长度检测未通过
                    if (!CheckRuleFactory.getLengthRuleImpl().check(fieldValue, attribute)) {
                        // 超出长度，检测失败
                        return RequestCheckMessageUtils.getLengthOutOfValue(attribute);
                    }
                }
                // 检测类型是否需要匹配
                if (attribute.isCheckType()) {
                    // 类型检测未通过
                    if (!CheckRuleFactory.getInputTypeRuleImpl(attribute.getInputType()).check(fieldValue, attribute)) {
                        // 类型不匹配，检测失败
                        return RequestCheckMessageUtils.getInputTypeError(attribute);
                    }
                }
            }
        }
        // 检测循环结束，成功检测
        return RequestCheckMessageUtils.getSuccessMessage();
    }


}
