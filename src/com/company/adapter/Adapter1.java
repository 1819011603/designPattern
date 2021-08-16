package com.company.adapter;

/**
 * @author 18190
 * @Date: 2021/8/16  12:02
 * @VERSION 1.0
 *
 * 类适配器 单继承方式 不够灵活
 */
public class Adapter1 extends Adaptee implements Target{

    @Override
    public void method1() {
        super.method1();
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
}
