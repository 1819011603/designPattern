package com.company.singleton;

/**
 * @author 18190
 * @Date: 2021/8/7  12:27
 * @VERSION 1.0
 */
public class HungrySingleton {
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();
    private HungrySingleton(){
        if (getHungrySingleton() != null){
            throw new RuntimeException("保证单例");
        }
    }

    public static HungrySingleton getHungrySingleton() {
        return HUNGRY_SINGLETON;
    }
}
