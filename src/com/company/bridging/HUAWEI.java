package com.company.bridging;

/**
 * @author 18190
 * @Date: 2021/8/16  20:07
 * @VERSION 1.0
 */
public class HUAWEI implements Brand {
    @Override
    public void open() {
        System.out.println("HUAWEI open");
    }

    @Override
    public void call() {
        System.out.println("HUAWEI call");
    }

    @Override
    public void close() {
        System.out.println("HUAWEI close");
    }
}
