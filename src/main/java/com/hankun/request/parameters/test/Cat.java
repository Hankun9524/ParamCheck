package com.hankun.request.parameters.test;

import com.hankun.request.parameters.annotation.ParamNotNull;


/**
 *
 *
 * @author HanKun
 * @version 1.0
 *  2020/3/5
 */
public class Cat extends Annimation {
    @ParamNotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
