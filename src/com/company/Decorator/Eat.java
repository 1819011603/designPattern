package com.company.Decorator;

/**
 * @author 18190
 * @Date: 2021/8/16  21:02
 * @VERSION 1.0
 *
 * 抽象接口
 */
public abstract class Eat {
    protected String desc;
    protected float aFloat =  0.0f;
    public  float cost(){
        return 0.0f;
    }


    public Float getaFloat() {
        return aFloat;
    }

    public void setaFloat(Float aFloat) {
        this.aFloat = aFloat;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
