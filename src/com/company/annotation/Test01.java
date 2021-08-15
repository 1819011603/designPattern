package com.company.annotation;

import java.util.ArrayList;

/**
 * @author 18190
 * @Date: 2021/8/14  14:38
 * @VERSION 1.0
 *
 * 三个内置注解
 */

@SuppressWarnings("all")
public class Test01 {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }

    public void test01(){
        ArrayList<Object> objects = new ArrayList<>();
    }

    public static void main(String[] args) {
        Test01.test();
    }

}
