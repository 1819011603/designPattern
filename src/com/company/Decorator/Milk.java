package com.company.Decorator;

/**
 * @author 18190
 * @Date: 2021/8/16  21:16
 * @VERSION 1.0
 *
 * 饮料
 */
public class Milk extends DrinkDecorator {
    public Milk(Eat eat) {
        super(eat);
        setDesc("一杯牛奶");
        setaFloat(2.0f);
    }
}
