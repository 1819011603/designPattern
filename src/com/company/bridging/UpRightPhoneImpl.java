package com.company.bridging;

/**
 * @author 18190
 * @Date: 2021/8/16  20:11
 * @VERSION 1.0
 */
public class UpRightPhoneImpl extends Phone {
    public UpRightPhoneImpl(Brand brand) {
        super(brand);

    }

    @Override
    public void open() {

        System.out.print("UpRight ");
        super.open();
    }

    @Override
    public void call() {
        System.out.print("UpRight ");
        super.call();
    }

    @Override
    public void close() {
        System.out.print("UpRight ");
        super.close();
    }
}
