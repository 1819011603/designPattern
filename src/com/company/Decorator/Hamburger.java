package com.company.Decorator;

/**
 * @author 18190
 * @Date: 2021/8/16  21:04
 * @VERSION 1.0
 *
 * 主食
 */
public class Hamburger extends Eat {
    public Hamburger() {
        super.desc = "汉堡包";
        super.aFloat = 11.0f;
    }

    @Override
    public float cost() {
        System.out.println(super.desc + " " +  super.aFloat);
        return aFloat;
    }
}
