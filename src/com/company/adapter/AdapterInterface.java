package com.company.adapter;

/**
 * @author 18190
 * @Date: 2021/8/16  12:07
 * @VERSION 1.0
 * 接口适配器  提供默认方法  比直接的Target要方便
 */
public interface AdapterInterface extends Target{

    @Override
    default void method1(){
        System.out.println("default interface method1");
    }

    @Override
    default void method2(){
        System.out.println("default interface method2");
    }
}
