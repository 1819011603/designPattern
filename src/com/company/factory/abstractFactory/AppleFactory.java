package com.company.factory.abstractFactory;

import com.company.factory.abstractFactory.AbstractFactory;
import com.company.factory.abstractFactory.computer.Computer;
import com.company.factory.abstractFactory.computer.Macbook;
import com.company.factory.abstractFactory.computer.MiComputer;
import com.company.factory.abstractFactory.phone.IPhone;
import com.company.factory.abstractFactory.phone.Phone;

/**
 * @author 18190
 * @Date: 2021/8/15  21:56
 * @VERSION 1.0
 */
public class AppleFactory extends AbstractFactory {
    @Override
    public Phone makePhone() {
        return new IPhone();
    }

    @Override
    public Computer makeComputer() {
        return new Macbook();
    }
}
