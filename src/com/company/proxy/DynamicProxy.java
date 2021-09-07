package com.company.proxy;

import javafx.beans.binding.ObjectExpression;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 18190
 * @Date: 2021/9/6  10:27
 * @VERSION 1.0
 *
 * 动态代理：
 * Proxy 中的 newProxyInstance 和 InvocationHandler接口实现类
 * Proxy 中的 newProxyInstance 创建代理对象（代理类 extends Proxy implement 接口数组）
 * newProxyInstance 方法里面获取到代理类，如果类的作用不能访问，使其能被访问到，最后实例化代理类。这段代码中最为核心的是获取代理类的getProxyClass0方法。
 * InvocationHandler接口实现类 为真实类的所有接口方法增加统一的逻辑
 */
public class DynamicProxy {
    /**
     * newProxyInstance方法：
     * final Class<?>[] intfs = interfaces.clone();  拷贝接口
     * Class<?> cl = getProxyClass0(loader, intfs);  类加载器和接口获得代理类Class 如果实现给定接口的给定加载程序定义的代理类存在，这将简单地返回缓存副本；否则，它将通过ProxyClassFactory创建代理类
     * final Constructor<?> cons = cl.getConstructor(constructorParams);  根据构造器参数获得代理类的构造器
     * cons.newInstance(new Object[]{h});  反射调用newInstance 实例化代理类对象
     */

    public static Object getProxy(Object target)throws Exception{

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),new TargetInvoker(target));
    }




}

class TargetInvoker implements InvocationHandler {

    private final Object target;

    public TargetInvoker(Object target) {
        this.target = target;
    }


    @SuppressWarnings("unchecked")
    public <T> T newInstance() throws Exception {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),new TargetInvoker(target));
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行代理前");

        if(method.getDeclaringClass() == Object.class){
            System.out.println("Object Method");
        }
        Object result = method.invoke(target,args);
        System.out.println("执行代理后");
        return result;
    }
}
