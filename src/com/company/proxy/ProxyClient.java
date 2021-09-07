package com.company.proxy;

import sun.misc.ProxyGenerator;

import java.io.*;
import java.lang.reflect.Modifier;

/**
 * @author 18190
 * @Date: 2021/9/6  9:59
 * @VERSION 1.0
 *
 * 代理模式
 * Subject: 抽象角色, 真实对象和代理对象的共同接口.
 * RealSubject: 真实角色, 代理角色所代表的真实对象, 是我们最终要引用的对象.
 * Proxy: 代理角色, 它是真实角色的封装, 其内部持有真实角色的引用, 并且提供了和真实角色一样的接口,
 *        因此程序中可以通过代理角色来操作真实的角色, 并且还可以附带其他额外的操作.
 *
 * 代理模式的优点
 * 代理模式能够协调调用者和被调用者, 在一定程度上降低了系统的耦合度.
 * 代理模式可以提供更大的灵活性
 *
 *
 * 代理模式的缺点
 * 由于在客户端和真实主题之间增加了代理对象, 因此有些类型的代理模式可能会造成请求的处理速度变慢
 * 实现代理模式需要额外的工作, 有些代理模式的实现 非常复杂
 */
public class ProxyClient {
    public static void main(String[] args) throws Exception {
        StaticProxy proxy = new StaticProxy(new Cat());
        proxy.call();


        // 动态地创建代理并且动态地处理所代理对象的方法调用.
        Animal proxy1 = (Animal)DynamicProxy.getProxy(new Cat());
        System.out.println(proxy1.getClass().getName());
        proxy1.call();

        TargetInvoker targetInvoker = new TargetInvoker(new Cat());
        Animal a = (Animal)targetInvoker.newInstance();
        a.call();


        // 生成代理类 generateProxyClass（代理类名称、接口数组、访问类型）
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "CatName", new Class[]{Cat.class},  Modifier.PUBLIC | Modifier.FINAL);
        OutputStream outputStream = new FileOutputStream(new File("d:/JdkProxy.class"));
        outputStream.write(proxyClassFile);



        proxy1.toString();
        proxy1.hashCode();
        System.out.println(proxy1.equals(DynamicProxy.getProxy(new Cat())));


    }
}
