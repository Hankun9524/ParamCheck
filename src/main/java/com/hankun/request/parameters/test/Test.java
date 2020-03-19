package com.hankun.request.parameters.test;

import com.hankun.request.parameters.ParamCheckUtils;
import com.hankun.request.parameters.exception.ParamCheckErrorException;

/**
 *
 *
 * @author HanKun
 * @version 1.0
 *  2020/3/5
 */
public class Test {


    public static void main(String[] args) throws ParamCheckErrorException {
        LittleCat cat = new LittleCat();
        cat.setWeight("100");
        ParamCheckUtils.check(cat);
    }

}
