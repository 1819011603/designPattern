package com.company.adapter;

/**
 * @author 18190
 * @Date: 2021/8/16  12:10
 * @VERSION 1.0
 *
 * 接口适配器的实现类 可以自由的重写父接口的方法
 */
public class InterfaceAdapter implements AdapterInterface {

    private Adaptee adaptee;

    public InterfaceAdapter() {
    }

    public InterfaceAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void method1() {
        System.out.println("Interface Adapter method1");
    }


}
