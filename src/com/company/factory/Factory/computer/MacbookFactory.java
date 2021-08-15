package com.company.factory.Factory.computer;

/**
 * @author 18190
 * @Date: 2021/8/15  21:03
 * @VERSION 1.0
 */
public class MacbookFactory extends AbstractComputerFactory {


    @Override
    public Computer makeComputer() {
        return new Macbook();
    }
}
