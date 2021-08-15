package com.company.factory.abstractFactory;

import com.company.factory.abstractFactory.computer.Computer;
import com.company.factory.abstractFactory.phone.Phone;

/**
 * @author 18190
 * @Date: 2021/8/15  21:57
 * @VERSION 1.0
 *
 *
 *
 * 简单工厂方法 是将生产的所有手机放到一个工厂中  这个工厂只可以生产手机  将其他类型的产品的简单工厂整合起来 也可以生产出所有的产品  但是它不符合开闭原则
 *
 * 工厂模式  是将简单工厂方法的 一条if-else语句  转换为 一个具体的工厂类  简单工厂一个if-else语句生产一个产品  工厂模式的一个具体的工厂生产一个产品  符合开闭原则 但是这也导致具体的工厂类数目太多
 *          一个简单工厂的功能就是 工厂模式一个抽象类的功能
 *
 * 抽象工厂模式  由于工厂模式类增加的太多  所以将几个产品横向组成一个产品族放到一个抽象类中  这样就能减少类的数目   但同时产品族当中如果产品的数目有所改动（增加一个平板生产的方法） 那么将破坏开闭原则
 *             所有之前继承该抽象类的所有工厂类都将进行修改
 *             但如果只是 增加一个产品族的具体类型  比如加个华为的手机、电脑生产 则不会修改之前的代码 符合开闭原则
 *
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        // 小米的生产放在一个工厂中
        AbstractFactory miFactory = new MiFactory();
        Phone phone = miFactory.makePhone();
        Computer computer = miFactory.makeComputer();
        phone.make();
        computer.make();

        // 苹果的生产放在一个工厂中
        AbstractFactory appleFactory = new AppleFactory();
        Phone phone1 = appleFactory.makePhone();
        Computer computer1 = appleFactory.makeComputer();
        phone1.make();
        computer1.make();


    }
}
