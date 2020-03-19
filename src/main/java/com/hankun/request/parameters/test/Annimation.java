package com.hankun.request.parameters.test;

import com.hankun.request.parameters.annotation.ParamNotNull;


/**
 *
 *
 * @author HanKun
 * @version 1.0
 *
 */
public class Annimation {

    @ParamNotNull
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
