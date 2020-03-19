package com.hankun.request.parameters.model;


import java.lang.reflect.Field;

import com.hankun.request.parameters.annotation.InputType;
import com.hankun.request.parameters.annotation.LengthModel;

/**
 * 字段的属性存储
 *
 * @author Hankun
 */
public class FieldAttribute {

    /**
     * 是否检测不能为空
     */
    private boolean checkEmpty = false;

    /**
     * 是否进行长度检测
     */
    private boolean checkLength = false;

    /**
     * 是否进行输入类型的检测
     */
    private boolean checkType = false;

    /**
     * 对象和数组的标识，在这种情况标记下，才会去做对象属性或者数组属性的检测
     */
    private boolean checkObject = false;

    /**
     * 输入类型的检测
     */
    private InputType inputType;

    /**
     * 别名标识
     */
    private String alias;


    /**
     * 长度检测类型
     */
    private LengthModel lengthModel;

    /**
     * 长度检测的约束值
     */
    private int[] length;


    /**
     * 字段值
     */
    private Field field;


    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public boolean isCheckObject() {
        return checkObject;
    }

    public void setCheckObject(boolean checkObject) {
        this.checkObject = checkObject;
    }

    public boolean isCheckLength() {
        return checkLength;
    }

    public void setCheckLength(boolean checkLength) {
        this.checkLength = checkLength;
    }

    public boolean isCheckType() {
        return checkType;
    }

    public void setCheckType(boolean checkType) {
        this.checkType = checkType;
    }


    public boolean isCheckEmpty() {
        return checkEmpty;
    }

    public void setCheckEmpty(boolean checkEmpty) {
        this.checkEmpty = checkEmpty;
    }

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }


    public LengthModel getLengthModel() {
        return lengthModel;
    }

    public void setLengthModel(LengthModel lengthModel) {
        this.lengthModel = lengthModel;
    }

    public int[] getLength() {
        return length;
    }

    public void setLength(int[] length) {
        this.length = length;
    }

}
