package com.company.factory.Factory;

import com.company.factory.Factory.computer.AbstractComputerFactory;
import com.company.factory.Factory.computer.Computer;
import com.company.factory.Factory.computer.MacbookFactory;
import com.company.factory.Factory.computer.MiComputerFactory;
import com.company.factory.Factory.phone.AbstractPhoneFactory;
import com.company.factory.Factory.phone.IPhoneFactory;
import com.company.factory.Factory.phone.MiPhoneFactory;
import com.company.factory.Factory.phone.Phone;

/**
 * @author 18190
 * @Date: 2021/8/15  21:35
 * @VERSION 1.0
 *
 * 工厂模式
 * 有多少个具体的产品就有多少个工厂
 * 一个工厂只生产一个产品
 * 一个抽象工厂生产一类产品  AbstractPhoneFactory 生产手机  AbstractComputerFactory 生产电脑
 * 一个具体的工厂相当于一个静态方法简单工厂的一个方法 将方法改为工厂  需要用户记住这些具体的工厂的名字才可以生产
 *
 * 简单工厂是一个工厂生产一类产品
 */
public class FactoryTest {
    public static void main(String[] args) {

        // 生产iPhone有一个 IPhoneFactory
        AbstractPhoneFactory iPhoneFactory = new IPhoneFactory();
        Phone phone = iPhoneFactory.makePhone();
        phone.make();

        // 生产MiPhone有一个 MIPhoneFactory
        AbstractPhoneFactory miPhoneFactory = new MiPhoneFactory();
        Phone phone1 = miPhoneFactory.makePhone();
        phone1.make();


        // 生产MiComputer有一个 MIComputerFactory
        AbstractComputerFactory miComputer = new MiComputerFactory();
        Computer computer = miComputer.makeComputer();
        computer.make();

        // 生产macbook有一个 macbookFactory
        AbstractComputerFactory macbookFactory = new MacbookFactory();
        Computer computer1 = macbookFactory.makeComputer();
        computer1.make();


    }
}
