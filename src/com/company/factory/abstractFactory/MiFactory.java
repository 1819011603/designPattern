package com.company.factory.abstractFactory;

import com.company.factory.abstractFactory.computer.Computer;
import com.company.factory.abstractFactory.computer.MiComputer;
import com.company.factory.abstractFactory.phone.MiPhone;
import com.company.factory.abstractFactory.phone.Phone;

/**
 * @author 18190
 * @Date: 2021/8/15  21:56
 * @VERSION 1.0
 */
public class MiFactory extends AbstractFactory {
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }

    @Override
    public Computer makeComputer() {
        return new MiComputer();
    }
}
