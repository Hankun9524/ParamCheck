package com.hankun.request.parameters;

import com.hankun.request.parameters.core.CheckCore;
import com.hankun.request.parameters.exception.ParamCheckErrorException;
import com.hankun.request.parameters.model.ParamsCheckResult;

/**
 * 参数注解工具
 *
 * @author Hankun
 */
public class ParamCheckUtils {


    /**
     * 字段的检测结果
     *
     * @param obj 检测对象
     * @throws ParamCheckErrorException  会抛出异常，用全局捕获进行捕获
     *
     */
    public static void check(Object obj) throws ParamCheckErrorException {
        ParamsCheckResult result = CheckCore.check(obj);
        if (!result.isSuccess()) {
            throw new ParamCheckErrorException(result.getMessage());
        }
    }


    /**
     * 进行检测，详细的获取到内部的参数合法性的信息
     *
     * @param object 待检测的对象类型
     * @return 检测的信息
     */
    public static ParamsCheckResult checkParam(Object object) {
        return CheckCore.check(object);
    }


}
