package com.company.proxy.Dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 18190
 * @Date: 2021/9/6  16:47
 * @VERSION 1.0
 */
public class EmployeeInvoker implements InvocationHandler {
    private Object target;

    public EmployeeInvoker(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Pre");
        Object invoke = method.invoke(target, args);
        System.out.println("beHind");
        return invoke;
    }

    public Object getTarget() {
        return target;
    }
}
