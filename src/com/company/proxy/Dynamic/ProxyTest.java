package com.company.proxy.Dynamic;

import com.company.prototype.AsiaSheep;

/**
 * @author 18190
 * @Date: 2021/9/6  16:46
 * @VERSION 1.0
 */
public class ProxyTest {
    public static void main(String[] args) {
        BankEmployee o = (BankEmployee)MyProxy.newInstance(BankEmployee.class.getClassLoader(), BankEmployee.class.getInterfaces(), new EmployeeInvoker(new BankEmployee()), BankEmployee.class);

        System.out.println(o.getClass().getName());


        o.hhh(null,0,null);
        o.yyy();
        o.fdw(null);

        o.ttt(null,null);
        o.fineyyy();



//        AsiaSheep[] asiaSheep = new AsiaSheep[10];
//        System.out.println(asiaSheep.getClass().getName());
//        System.out.println(asiaSheep.getClass().getSimpleName());
//        System.out.println(asiaSheep.getClass().getComponentType().getName());
//        Double[] doubles = new Double[10];
//        System.out.println(doubles.getClass().getName());
//        System.out.println(doubles.getClass().getSimpleName());
//        System.out.println(doubles.getClass().getComponentType().getName());
//
//        double[] doubles1 = new double[10];
//        System.out.println(doubles1.getClass().getName());
//        System.out.println(doubles1.getClass().getSimpleName());
//        System.out.println(doubles1.getClass().getComponentType().getName());

    }
}
