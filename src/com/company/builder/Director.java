package com.company.builder;

/**
 * @author 18190
 * @Date: 2021/8/15  19:29
 * @VERSION 1.0
 *
 * 指挥者只是用来控制生产的具体流程与顺序
 */
public class Director {



    public Product construct1( Builder builder){
        builder.brand();
        builder.desc();
        builder.model();
        builder.scene();
        builder.price();
        return builder.getInstance();
    }
    public Product construct2( Builder builder){
//        builder.brand();
        builder.model();
        builder.desc();
        builder.price();
        builder.scene();
        return builder.getInstance();
    }

    /**
     * 链式调用更加方便
     */
    public Product construct3(SimpleBuilder builder){
        return builder.brand().desc().model().scene().price().getInstance();
    }
}
