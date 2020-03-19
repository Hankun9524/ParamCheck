package com.hankun.request.parameters.core;

import java.util.List;

import com.hankun.request.parameters.cache.ParametersCache;
import com.hankun.request.parameters.message.RequestCheckMessageUtils;
import com.hankun.request.parameters.model.FieldAttribute;
import com.hankun.request.parameters.model.ParamsCheckResult;

/**
 * 检测代码核心
 *
 * @author Hankun
 */
public class CheckCore {


    /**
     * 参数的检测结果的规程
     *
     * @param obj 检测对象
     * @return 返回检测结果
     */
    public static ParamsCheckResult check(Object obj) {
        try {
            // 先获取对象的类
            Class<?> cls = obj.getClass();
            // 获取属性的检测限定
            List<FieldAttribute> fieldAttributeList = ParametersCache.getClassFiledAttribute(cls.getName());
            // 如果为空，则是没有存储过检测的对象,需要获取一次检测对象的限定属性
            if (fieldAttributeList == null) {
                fieldAttributeList = ReflexClassCore.resolveAnnotation(cls);
            }
            // 获取到属性限定后，开始对对象的所有需要检测的属性按照类型去检测
            return FieldCheckCore.fieldCheck(obj, fieldAttributeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //检测发生错误，但是让检测可以正常运行，打印出错日志，收集日志继续修正
        return RequestCheckMessageUtils.getSuccessMessage();
    }

}
