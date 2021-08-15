package com.company.factory.simpleFactory;

/**
 * @author 18190
 * @Date: 2021/8/15  21:11
 * @VERSION 1.0
 */

//  将if-else  用方法名来区分 让用户看到名字就知道生产什么产品
public class MulMethodSimpleFactory {
    public Phone makeIPhone(){
        return new IPhone();
    }

    public Phone makeMiPhone(){
        return new MiPhone();
    }
}
