package com.company.bridging;

/**
 * @author 18190
 * @Date: 2021/8/16  20:11
 * @VERSION 1.0
 */
public class FolderPhoneImpl extends Phone {
    public FolderPhoneImpl(Brand brand) {
        super(brand);

    }

    @Override
    public void open() {

        System.out.print("folder ");
        super.open();
    }

    @Override
    public void call() {
        System.out.print("folder ");
        super.call();
    }

    @Override
    public void close() {
        System.out.print("folder ");
        super.close();
    }
}
