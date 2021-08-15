package com.company.builder;

/**
 * @author 18190
 * @Date: 2021/8/15  19:35
 * @VERSION 1.0
 */
public class BuilderTest {
    public static void main(String[] args) {
        System.out.println("==============用director来确定顺序======================");
        // Director 全局都只需要一个
        Director director = new Director();


        Builder builder = new SpecificProduct1();
        Product product = director.construct1(builder);
        // 每创建一个Product 就要新建一个Builder
        builder = new SpecificProduct1();
        Product product1 = director.construct2(builder);
        System.out.println(product);
        System.out.println(product1);


        builder = new SpecificProduct2();
        Product product2 = director.construct1(builder);
        builder = new SpecificProduct2();
        Product product3 = director.construct2(builder);
        System.out.println(product2);
        System.out.println(product3);

        System.out.println("==============更加简易的Builder======================");
        SimpleBuilder simpleBuilder = new SpecificProduct3();
        //  多次调用有可能出错
        Product instance = simpleBuilder.brand().desc().model().scene().price().getInstance();
        System.out.println(instance);
        simpleBuilder = new SpecificProduct3();
        // 调用方法  不易出错
        Product product4 = director.construct3(simpleBuilder);
        System.out.println(product4);



        simpleBuilder = new SpecificProduct4();
        Product instance1 = simpleBuilder.brand().desc().model().scene().getInstance();
        System.out.println(instance1);


    }
}
