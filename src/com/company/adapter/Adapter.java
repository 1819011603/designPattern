package com.company.adapter;

/**
 * @author 18190
 * @Date: 2021/8/16  11:56
 * @VERSION 1.0
 *
 * 对象适配器 组合方式
 */
public class Adapter implements Target {
    private Adaptee adaptee;
    public Adapter(){

    }

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void method1() {
        adaptee.method1();
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
}
