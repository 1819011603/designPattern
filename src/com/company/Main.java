package com.company;

import com.company.prototype.NotSerializable;
import com.company.prototype.Sheep;
import com.company.singleton.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException {
//        lazySingleton();

//        HungrySingletonTest();


//        InnerStaticSingletonTest();
//        InnerStaticSingletonTest1();
//        System.out.println(InnerStaticSingleton2.getSingleton() == InnerStaticSingleton2.getSingleton().clone());

//        EnumSingleton();
        Sheep sheep = new Sheep("tom",1,"red");
        sheep.setFriend(new Sheep("zzl",12,"black"));
        sheep.setNotSerializable(new NotSerializable("colne1",11));

        Sheep clone = sheep.clone();
        clone.getFriend().setName("ppq");
        clone.getNotSerializable().setName("clone2");
        Sheep clone1 = clone.clone();
        clone1.getNotSerializable().setAge(100);
        System.out.println(sheep);
        System.out.println(clone);
        System.out.println(clone1);

    }

    private static void EnumSingleton() {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        instance.get();
        EnumSingleton second = EnumSingleton.SECOND;
        System.out.println(instance == second);
        System.out.println(instance.uu == second.uu);
        System.out.println(instance.uu);
        System.out.println(second.uu);
    }

    private static void InnerStaticSingletonTest1() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        InnerStaticSingleton singleton = InnerStaticSingleton.getSingleton();
        System.out.println(singleton);


        Class<InnerStaticSingleton1> innerStaticSingletonClass = InnerStaticSingleton1.class;
        Constructor<InnerStaticSingleton1> declaredConstructor = innerStaticSingletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerStaticSingleton1 innerStaticSingleton = declaredConstructor.newInstance();
        System.out.println();
        // 创建外部类对象 并未加载内部类   静态内部类只有当使用的时候才会加载 InnerStaticSingleton.getSingleton()方法时加载内部类
        System.out.println(innerStaticSingleton == InnerStaticSingleton1.getSingleton());
    }

    /**
     * 反射破坏单例
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static void InnerStaticSingletonTest() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Class<InnerStaticSingleton> innerStaticSingletonClass = InnerStaticSingleton.class;
        Constructor<InnerStaticSingleton> declaredConstructor = innerStaticSingletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerStaticSingleton innerStaticSingleton = declaredConstructor.newInstance();
        System.out.println();
        // 创建外部类对象 并未加载内部类   静态内部类只有当使用的时候才会加载 InnerStaticSingleton.getSingleton()方法时加载内部类
        System.out.println(innerStaticSingleton == InnerStaticSingleton.getSingleton());
    }

    private static void HungrySingletonTest() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<HungrySingleton> hungrySingletonClass = HungrySingleton.class;
        Constructor<HungrySingleton> declaredConstructor = hungrySingletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        HungrySingleton singleton = declaredConstructor.newInstance();
        System.out.println(singleton == HungrySingleton.getHungrySingleton());
    }

    private static void lazySingleton() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class lazySingletonClass = LazySingleton.class;
        Constructor declaredConstructor = lazySingletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazySingleton lazySingleton = (LazySingleton) declaredConstructor.newInstance();
        System.out.println(lazySingleton == LazySingleton.getLazySingleton());
    }
}
