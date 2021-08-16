package com.company.adapter;

/**
 * @author 18190
 * @Date: 2021/8/16  11:57
 * @VERSION 1.0
 *
 * 用户想要Adaptee具有 Target中的方法  但是Adaptee已经写完了  不能修改Adaptee源代码 破坏开闭原则
 *
 * 所以增加Adapter一个类  Adapter来实现Target中的方法  方法实际操作的对象还是Adaptee对象
 */
public class Adaptee {
    public void method1(){
        System.out.println("method1");
    }
}
