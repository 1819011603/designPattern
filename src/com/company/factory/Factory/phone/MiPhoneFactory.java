package com.company.factory.Factory.phone;

/**
 * @author 18190
 * @Date: 2021/8/15  21:33
 * @VERSION 1.0
 */
public class MiPhoneFactory extends AbstractPhoneFactory {
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}
