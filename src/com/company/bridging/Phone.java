package com.company.bridging;

/**
 * @author 18190
 * @Date: 2021/8/16  20:05
 * @VERSION 1.0
 */
public abstract class Phone {
    protected Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void  open(){
        this.brand.open();
    }

    public void call(){
        this.brand.call();
    }
    public void close(){
        this.brand.close();
    }


}
