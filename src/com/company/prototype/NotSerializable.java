package com.company.prototype;

import java.io.Serializable;

/**
 * @author 18190
 * @Date: 2021/8/13  15:46
 * @VERSION 1.0
 */
public class NotSerializable implements Serializable {
    private static final long serialVersionUID = 44556889462L;
    private String name;
    private int age;
    public NotSerializable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "NotClone{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}
