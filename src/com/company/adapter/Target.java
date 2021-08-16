package com.company.adapter;

/**
 * @author 18190
 * @Date: 2021/8/16  11:58
 * @VERSION 1.0
 *
 * 目标类 用户想将Adaptee 具有Target接口的属性 如果重写Adaptee 直接继承Target接口重写即可
 *
 * 现在不能重写  就增加一个类继承Target 将Adaptee对象传入该类  相当于操作Adaptee对象 增加一层封装
 */
public interface Target {
    void method1();
    void method2();
}
