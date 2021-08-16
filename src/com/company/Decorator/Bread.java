package com.company.Decorator;

/**
 * @author 18190
 * @Date: 2021/8/16  21:04
 * @VERSION 1.0
 *
 * 主食
 */
public class Bread extends Eat {
    public Bread() {
        super.desc = "面包";
        super.aFloat = 5.0f;
    }

    @Override
    public float cost() {
        System.out.println(super.desc + " " +  super.aFloat);
        return aFloat;
    }
}
