package com.company.bridging;

/**
 * @author 18190
 * @Date: 2021/8/16  20:07
 * @VERSION 1.0
 */
public class ViVo implements Brand {
    @Override
    public void open() {
        System.out.println("ViVo open");
    }

    @Override
    public void call() {
        System.out.println("ViVo call");
    }

    @Override
    public void close() {
        System.out.println("ViVo close");
    }
}
