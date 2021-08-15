package com.company.factory.Factory.phone;

/**
 * @author 18190
 * @Date: 2021/8/15  21:25
 * @VERSION 1.0
 */
public class IPhoneFactory extends AbstractPhoneFactory {


    @Override
    public Phone makePhone() {
        return new IPhone();
    }
}
