package com.company.prototype;

import java.beans.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author 18190
 * @Date: 2021/8/13  15:20
 * @VERSION 1.0
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, IllegalAccessException, IntrospectionException {
        System.out.println("===============Java 重写Cloneable和Serializable接口  序列化与反序列化深拷贝=======================");

        Sheep sheep = new Sheep("tom",1,"red");
        sheep.setFriend(new Sheep("zzl",12,"black"));
        sheep.setNotSerializable(new NotSerializable("colne1",11));


        // 实现Cloneable、Serializable接口和重写clone方法
        // 为了实现deepClone   NotSerializable也得实现Serializable接口
        Sheep clone = sheep.clone();

        System.out.println(sheep == clone);

        System.out.println(clone.getNotSerializable() == sheep.getNotSerializable());



        System.out.println("===============Apache Commons SerializationUtils 实现深拷贝=======================");

        // 借助 Apache Commons 可以直接实现  AsiaSheep无需实现Cloneable和Serializable接口
        AsiaSheep sheep1 = new AsiaSheep("tom",1,"red","上海");
        sheep1.setFriend(new Sheep("zzl",12,"black"));
        sheep1.setNotSerializable(new NotSerializable("colne1",11));
        Sheep sheep2 = sheep1.deepClone();

        System.out.println(sheep1 == sheep2);
        System.out.println(sheep2.getNotSerializable() == sheep1.getNotSerializable());


        System.out.println("===================专业序列化工具 Protostuff 实现深拷贝==================================");
        Sheep sheep3 = sheep1.deepClone1();
        System.out.println(sheep3  == sheep1);
        System.out.println(sheep3.getNotSerializable() == sheep1.getNotSerializable());
        System.out.println("===================Apache Commons BeanUtils.copyProperties 实现浅拷贝==================================");
        Sheep sheep4 = sheep3.shallowClone();
        System.out.println(sheep4 == sheep3);
        System.out.println(sheep4.getNotSerializable() == sheep3.getNotSerializable());
        System.out.println(sheep4.getName() == sheep3.getName());

        System.out.println("=======================实现Cloneable接口 重写clone方法 实现浅拷贝(String、自定义类对象都只拷贝引用)========================================");
        CloneSheep sheep5 = new CloneSheep(sheep1);
        CloneSheep sheep6 =  sheep5.clone();

        System.out.println(sheep6 == sheep5);
        System.out.println(sheep6.getSheep() == sheep5.getSheep());
        System.out.println(sheep5);
        System.out.println(sheep6);
        System.out.println("浅拷贝String: " + (sheep5.getS() == sheep6.getS()));
        sheep5.setS(new StringBuilder("des"));
        System.out.println("浅拷贝String: " + sheep5.getS().toString().equals(sheep6.getS().toString()));



        System.out.println("===================== java 内省三件套  Introspector、BeanInfo、PropertyDescriptor========================================");

        // class属性 get方法
        BeanInfo beanInfo4 = Introspector.getBeanInfo(Object.class);
        System.out.println(Arrays.toString(beanInfo4.getPropertyDescriptors()));


        // 去取多余的class属性 （Object中拥有class属性）
        BeanInfo beanInfo = Introspector.getBeanInfo(Sheep.class, Object.class);
        System.out.println(Arrays.toString(beanInfo.getPropertyDescriptors()));
        // 多余的class属性 但是却没有set方法
        BeanInfo beanInfo1 = Introspector.getBeanInfo(Sheep.class);
        System.out.println(Arrays.toString(beanInfo1.getPropertyDescriptors()));

        BeanInfo beanInfo2 = Introspector.getBeanInfo(AsiaSheep.class);
        System.out.println(Arrays.toString(beanInfo2.getPropertyDescriptors()));

        //    AsiaSheep.class的属性 包含父类 直到 Sheep.class（不包含）
        BeanInfo beanInfo3 = Introspector.getBeanInfo(AsiaSheep.class, Sheep.class);
        // bean类描述
        BeanDescriptor beanDescriptor = beanInfo3.getBeanDescriptor();
        // bean类中方法描述
        MethodDescriptor[] methodDescriptors = beanInfo3.getMethodDescriptors();
        // bean中事件描述
        EventSetDescriptor[] eventSetDescriptors = beanInfo3.getEventSetDescriptors();
        // 额外bean描述
        BeanInfo[] additionalBeanInfo = beanInfo3.getAdditionalBeanInfo();
        System.out.println(beanDescriptor);
        System.out.println(Arrays.toString(beanInfo3.getPropertyDescriptors()));
        System.out.println(Arrays.toString(methodDescriptors));
        System.out.println(Arrays.toString(eventSetDescriptors));
        System.out.println(Arrays.toString(additionalBeanInfo));

        System.out.println("================Apache Commons BeanUtils 是Introspector、BeanInfo、PropertyDescriptor的封装=============");

    }
}
