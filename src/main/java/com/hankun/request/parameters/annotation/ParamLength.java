package com.hankun.request.parameters.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 长度的检测，需要进行长度检测的字段，标记此注解，默认检测长度是1000
 * <p>
 * 当设置为 最大最小或者相等检测模式时，检测的值取第一个值，如果设置是区间检测，最小值取第一个，最大值取第二个，必须设置第二个参数，否则会报错
 *
 * @author Hankun
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ParamLength {


    LengthModel lengthModel() default LengthModel.Max;


    /**
     * 长度检测，根据模式的不同，匹配不同的参数值
     *
     * @return 设置的校验值
     */
    int[] value() default {1000};

}
