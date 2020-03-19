package com.hankun.request.parameters.annotation;

/**
 *
 * @author HanKun
 * @version 1.0
 */
public enum LengthModel {

    /**
     * 最小检测模式，检测不能小于某个长度
     *
     */
    Min,

    /**
     * 最大检测模式，检测不能超出某个长度
     */
    Max,

    /**
     * 相等检测模式，检测必须等于某个长度
     *
     */
    Equal,

    /**
     * 区间加测模式
     *
     */
    Region

}
