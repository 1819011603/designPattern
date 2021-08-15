package com.company.factory.simpleFactory;

/**
 * @author 18190
 * @Date: 2021/8/15  21:01
 * @VERSION 1.0
 * 普通简单工厂
 */
public class NormalSimpleFactory {
    private Phone phone;
    public Phone makePhone(String phoneType){
        if("IPhone".equals(phoneType)){
            phone = new IPhone();

            return phone;
        }else if ("MiPhone".equals(phoneType)){
            phone = new MiPhone();
            return phone;
        }
        return null;
    }
}
