package com.company.factory.Factory.computer;

/**
 * @author 18190
 * @Date: 2021/8/15  21:44
 * @VERSION 1.0
 */
public class MiComputerFactory extends AbstractComputerFactory {
    @Override
    public Computer makeComputer() {
        return new MiComputer();
    }
}
