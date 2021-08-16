package com.company.Decorator;

/**
 * @author 18190
 * @Date: 2021/8/16  21:15
 * @VERSION 1.0
 *
 * 饮料
 */
public class Cola extends DrinkDecorator {

    public Cola(Eat eat) {
        super(eat);
        super.desc = "一杯可乐";
        super.aFloat = 3.0f;
    }
}
