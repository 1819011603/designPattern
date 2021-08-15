package com.company.factory.abstractFactory.computer;

/**
 * @author 18190
 * @Date: 2021/8/15  21:03
 * @VERSION 1.0
 */
public class MiComputer implements Computer {

    @Override
    public void make() {
        System.out.println("make miComputer");
    }
}
