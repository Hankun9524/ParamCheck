package com.hankun.request.parameters.message;

import com.hankun.request.parameters.model.FieldAttribute;
import com.hankun.request.parameters.model.ParamsCheckResult;
import com.hankun.request.parameters.util.StringUtils;

import java.util.Arrays;

/**
 * 返回检测的辅助信息
 *
 * @author Hankun
 */
public class RequestCheckMessageUtils {

    /**
     * 返回一个成功检测的消息
     *
     * @return 检测状态信息
     */
    public static ParamsCheckResult getSuccessMessage() {
        return new ParamsCheckResult(true, null);
    }

    /**
     * 长度超出最长的限制
     *
     * @param attribute 参数
     * @return 检测
     */
    public static ParamsCheckResult getLengthOutOfValue(FieldAttribute attribute) {
        //获取检测长度的类型
        String typeInfo;
        switch (attribute.getLengthModel()) {
            case Min:
                typeInfo = "长度必须大于" + attribute.getLength()[0];
                break;
            case Equal:
                typeInfo = "长度必须等于" + attribute.getLength()[0];
                break;
            case Region:
                typeInfo = "长度必须在" + attribute.getLength()[0] + "和" + attribute.getLength()[1] + "之间";
                break;
            default:
                typeInfo = "长度必须小于" + attribute.getLength()[0];
                break;
        }
        // 参数是否起了别名
        if (StringUtils.isEmpty(attribute.getAlias())) {
            // 没有别名，直接以字段名字为准
            String fieldName = attribute.getField().getName();
            return new ParamsCheckResult(false, fieldName + typeInfo);
        } else {
            return new ParamsCheckResult(false, attribute.getAlias() + typeInfo);
        }
    }


    /**
     * 参数类型不匹配
     *
     * @param attribute 注解属性
     * @return 输入类型错误
     */
    public static ParamsCheckResult getInputTypeError(FieldAttribute attribute) {
        // 参数是否起了别名
        if (StringUtils.isEmpty(attribute.getAlias())) {
            // 没有别名，直接以字段名字为准
            String fieldName = attribute.getField().getName();
            return new ParamsCheckResult(false, fieldName + "不符合规范");
        } else {
            return new ParamsCheckResult(false, attribute.getAlias() + "不符合规范");
        }
    }


    /**
     * 参数不能为空的检测
     *
     * @param attribute 注解属性
     * @return 为空检测的返回
     */
    public static ParamsCheckResult getEmptyTypeError(FieldAttribute attribute) {
        // 参数是否起了别名
        if (StringUtils.isEmpty(attribute.getAlias())) {
            // 没有别名，直接以字段名字为准
            String fieldName = attribute.getField().getName();
            return new ParamsCheckResult(false, fieldName + "不能为空");
        } else {
            return new ParamsCheckResult(false, attribute.getAlias() + "不能为空");
        }
    }


    /**
     * 注解类型匹配错误
     *
     * @param attribute 注解属性
     * @return 返回错误提示信息
     */
    public static ParamsCheckResult getCheckTypeError(FieldAttribute attribute) {
        // 参数是否起了别名
        if (StringUtils.isEmpty(attribute.getAlias())) {
            // 没有别名，直接以字段名字为准
            String fieldName = attribute.getField().getName();
            return new ParamsCheckResult(false, fieldName + "注解不能为CheckObject");
        } else {
            return new ParamsCheckResult(false, attribute.getAlias() + "注解不能为CheckObject");
        }
    }


}
