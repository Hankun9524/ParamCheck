package com.hankun.request.parameters.test;

import com.hankun.request.parameters.annotation.ParamNotNull;


/**
 * CopyRight (c)2019: <北京中航讯科技股份有限公司>
 *
 * @author HanKun
 * @version 1.0
 * @date 2020/3/5
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
