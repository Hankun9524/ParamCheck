package com.hankun.request.parameters.test;

import com.hankun.request.parameters.annotation.ParamNotNull;

/**
 *
 *
 * @author HanKun
 * @version 1.0
 *  2020/3/5
 */
public class LittleCat extends Cat{


    @ParamNotNull
    private String weight;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
