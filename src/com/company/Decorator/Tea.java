package com.company.Decorator;

/**
 * @author 18190
 * @Date: 2021/8/16  21:16
 * @VERSION 1.0
 *
 * 饮料
 */
public class Tea extends DrinkDecorator {
    public Tea(Eat eat) {
        super(eat);
        setDesc("一杯茶");
        setaFloat(4.0f);
    }
}
