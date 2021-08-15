package com.company.singleton;

import java.util.UUID;

/**
 * @author 18190
 * @Date: 2021/8/9  11:36
 * @VERSION 1.0
 */
public enum EnumSingleton {
    INSTANCE,
    SECOND;

    public int a = 0;
    int b = 0;
    public String uu = UUID.randomUUID().toString();
    public void get(){

    }
    private void set(){
        Object o = new Object();

    }
    static {
        System.out.println(INSTANCE.hashCode());
    }
}
