package com.company.bridging;

/**
 * @author 18190
 * @Date: 2021/8/16  20:07
 * @VERSION 1.0
 */
public class XiaoMi implements Brand {
    @Override
    public void open() {
        System.out.println("XiaoMi open");
    }

    @Override
    public void call() {
        System.out.println("XiaoMi call");
    }

    @Override
    public void close() {
        System.out.println("XiaoMi close");
    }
}
