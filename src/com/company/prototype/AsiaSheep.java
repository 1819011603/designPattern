package com.company.prototype;

/**
 * @author 18190
 * @Date: 2021/8/14  9:48
 * @VERSION 1.0
 */
public class AsiaSheep  extends Sheep{
    private String location;

    @Override
    public String toString() {
        return "AsiaSheep{" +
                "location='" + location + '\'' +
                '}';
    }

    public AsiaSheep(String location) {
        this.location = location;
    }

    public AsiaSheep(String name, int age, String color, String location) {
        super(name, age, color);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
