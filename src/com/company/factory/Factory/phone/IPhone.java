package com.company.factory.Factory.phone;

/**
 * @author 18190
 * @Date: 2021/8/15  21:03
 * @VERSION 1.0
 */
public class IPhone implements Phone {

    @Override
    public void make() {
        System.out.println("make IPhone");
    }
}
