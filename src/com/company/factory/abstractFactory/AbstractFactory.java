package com.company.factory.abstractFactory;

import com.company.factory.abstractFactory.computer.Computer;
import com.company.factory.abstractFactory.phone.Phone;

/**
 * @author 18190
 * @Date: 2021/8/15  21:53
 * @VERSION 1.0
 *
 * 可以生产多种产品（这些产品称为一个产品族）  产品族中产品数增加是会破坏开闭原则的，因为需要修改继承该抽象类的所有工厂的源代码
 * 但是增加一种具体的工厂符合开闭原则  会大大减少工厂类的数目
 */


public abstract class AbstractFactory {
    public abstract Phone makePhone();
    public abstract Computer makeComputer();
}
