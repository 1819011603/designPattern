package com.company.prototype;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.runtime.RuntimeSchema;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 18190
 * @Date: 2021/8/13  15:14
 * @VERSION 1.0
 */
public class Sheep implements Cloneable,Serializable{

    private static final long serialVersionUID = 424845L;
    private String name;
    private int age;
    private String color;
    private Sheep friend;

    // 序列化与反序列化必须 实现Serializable接口
    private NotSerializable notSerializable;

    public Sheep getFriend() {
        return friend;
    }

    public void setFriend(Sheep friend) {
        this.friend = friend;
    }

    public Sheep() {
    }

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public NotSerializable getNotSerializable() {
        return notSerializable;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", friend=" + friend +
                ", notSerializable=" + notSerializable +
                '}';
    }

    public void setNotSerializable(NotSerializable notSerializable) {
        this.notSerializable = notSerializable;
    }

    @Override
    public Sheep clone() throws CloneNotSupportedException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream os = new ObjectOutputStream(bos)) {
            os.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Sheep) ois.readObject();
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }

        // 浅拷贝
        return (Sheep)super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    /**
     * 借助 Apache Commons 可以直接实现  无需实现Cloneable和Serializable接口
     * @return  深拷贝
     */
    public Sheep deepClone(){
        byte[] serialize = SerializationUtils.serialize(this);
        Object deserialize = SerializationUtils.deserialize(serialize);
        return (Sheep) deserialize;
    }

    /**
     * 性能很差 速度上慢java clone的百倍不止  但是不需要实现Cloneable接口和Serializable接口
     * 无需实现Cloneable和Serializable接口
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Sheep shallowClone() throws InvocationTargetException, IllegalAccessException {
        Sheep sheep = new Sheep();

        //noinspection AlibabaAvoidApacheBeanUtilsCopy
        BeanUtils.copyProperties(sheep,this);
        return sheep;
    }

    // 专业序列化工具 Protostuff 实现深拷贝 不需要实现Cloneable接口和Serializable接口  速度很快
    public Sheep deepClone1(){

        RuntimeSchema<Sheep> schema = RuntimeSchema.createFrom(Sheep.class);
        byte[] bytes = ProtostuffIOUtil.toByteArray(this, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
//        System.out.println(bytes.length);
        //反序列化
        Sheep sc = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(bytes, sc, schema);
//        System.out.println(sc);
        return sc;

    }



}
