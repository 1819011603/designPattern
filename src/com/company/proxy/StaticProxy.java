package com.company.proxy;

/**
 * @author 18190
 * @Date: 2021/9/6  9:59
 * @VERSION 1.0
 * 静态代理就是在程序运行之前，代理类字节码.class就已编译好.
 * 通常一个静态代理类也只代理一个目标类，代理类和目标类都实现相同的接口。
 *
 *
 * 1.当我们在 Animal 接口中增加方法，这时不仅实现类 Cat 需要新增该方法的实现，同时，由于代理类实现了 Animal 接口，所以代理类也必须实现 Animal 新增的方法，这对项目规模较大时，在维护上就不太友好了。
 * 2.代理类实现Animal#call是针对 Cat 目标类的对象进行设置的，如果再需要添加 Dog 目标类的代理，那就必须再针对 Dog 类实现一个对应的代理类，这样就使得代理类的重用型不友好，并且过多的代理类对维护上也是比较繁琐。
 */

/**
 * 静态代理：
 * 1.接口中添加方法 要增加真实对象的方法实现和代理类中的方法实现 维护不友好 动态代理只需实现真实对象中的方法
 * 2.一个代理类对应一个真实类 增加真实类就要增加一个代理类 代理过多的问题
 * 3.程序运行前代理类的字节码文件就已经生成了  而动态代理的代理类是在程序运行时生成的
 */
public class StaticProxy implements Animal{

    private Animal animal;

    public StaticProxy(Animal animal){
        this.animal = animal;
    }


    @Override
    public void call() {
        System.out.println("Pre");
        animal.call();
        System.out.println("Behind");
    }
}


/**
 * 抽象角色
 */

interface Animal{
    void call();
}

/**
 * 真实角色
 */
class Cat implements Animal{

    @Override
    public void call() {
        System.out.println("Cat");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        return obj instanceof Animal;
    }

    @Override
    public String toString() {
        return "Cat{}";
    }
}