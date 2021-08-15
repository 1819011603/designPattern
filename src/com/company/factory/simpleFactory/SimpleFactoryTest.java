package com.company.factory.simpleFactory;

/**
 * @author 18190
 * @Date: 2021/8/15  21:01
 * @VERSION 1.0
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {

        System.out.println("===============简单普通工厂  工厂需要new  生产的产品通过参数来决定 需要用户了解参数信息======================");
        NormalSimpleFactory normalSimpleFactory = new NormalSimpleFactory();
        Phone iPhone = normalSimpleFactory.makePhone("IPhone");
        iPhone.make();
        iPhone = normalSimpleFactory.makePhone("MiPhone");
        iPhone.make();

        System.out.println("===============多方法简单工厂  工厂需要new=====================");
        MulMethodSimpleFactory mulMethodSimpleFactory = new MulMethodSimpleFactory();
        Phone phone = mulMethodSimpleFactory.makeIPhone();
        phone.make();
        Phone phone1 = mulMethodSimpleFactory.makeMiPhone();
        phone1.make();

        System.out.println("===============静态多方法简单工厂  工厂不需要new=====================");
        Phone phone2 = MulStaticMethodSimpleFactory.makeIPhone();
        phone2.make();
        Phone phone3 = MulStaticMethodSimpleFactory.makeMiPhone();
        phone3.make();

    }
}
