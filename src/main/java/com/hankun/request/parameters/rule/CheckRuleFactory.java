package com.hankun.request.parameters.rule;


import com.hankun.request.parameters.annotation.InputType;

/**
 * 检测规则的校验
 *
 * @author Hankun
 */
public class CheckRuleFactory {

    /**
     * 文本处理判定
     */
    private static CheckRuleInterface textInputImpl = new TextInputImpl();

    /**
     * 日期格式 yyyy-MM-dd
     */
    private static CheckRuleInterface dateInputImpl = new DateInputImpl();

    /**
     * 数字格式，整数
     */
    private static CheckRuleInterface numberInputImpl = new NumberInputImpl();

    /**
     * 小数点双精度检测
     */
    private static CheckRuleInterface numberDecimalInputImpl = new NumberDecimalInputImpl();

    /**
     * 手机号码的检测
     */
    private static CheckRuleInterface mobilePhoneInputImpl = new MobblePhoneInputImpl();

    /**
     * 密码的检测
     */
    private static CheckRuleInterface passwordInputImpl = new PasswordInputImpl();

    /**
     * 电子邮箱的检测
     */
    private static CheckRuleInterface emailInputImpl = new EmailInputImpl();

    /**
     * 邮箱检测
     */
    private static CheckRuleInterface urlInputImpl = new UrlInputImpl();


    /**
     * 身份证的校验
     */
    private static CheckRuleInterface idCardInputImpl = new IDNumberInputImpl();

    /**
     * 非空检测
     */
    private static CheckRuleInterface notNullImpl = new NotNullImpl();

    /**
     * 长度检测
     */
    private static CheckRuleInterface lengthImpl = new LengthImpl();


    /**
     * 获取输入类型的检测方式
     *
     * @param inputType 输入类型
     * @return 返回是否检测成功通过
     */
    public static CheckRuleInterface getInputTypeRuleImpl(InputType inputType) {
        switch (inputType) {
            case Date:
                return dateInputImpl;
            case Number:
                return numberInputImpl;
            case NumberDecimal:
                return numberDecimalInputImpl;
            case MobilePhone:
                return mobilePhoneInputImpl;
            case Password:
                return passwordInputImpl;
            case Email:
                return emailInputImpl;
            case Url:
                return urlInputImpl;
            case IdNumber:
                return idCardInputImpl;
            default:
                return textInputImpl;
        }
    }


    /**
     * 获取一个非空的检测对象
     *
     * @return 返回空类型的检测规则
     */
    public static CheckRuleInterface getEmptyRuleImpl() {
        return notNullImpl;
    }


    /**
     * 获取一个长度范围的检测
     *
     * @return 返回长度范围的检测，当不超过设定的长度的时候，是正确的内容信息
     */
    public static CheckRuleInterface getLengthRuleImpl() {
        return lengthImpl;
    }


}
