package com.company.singleton;

/**
 * @author 18190
 * @Date: 2021/8/7  12:04
 * @VERSION 1.0
 */
public class LazySingleton {
    private static volatile LazySingleton lazySingleton = null;

    /**
     * private 但不能阻止反射非法访问
     *          Class lazySingletonClass = LazySingleton.class;
     *         Constructor declaredConstructor = lazySingletonClass.getDeclaredConstructor();
     *         declaredConstructor.setAccessible(true);
     *         LazySingleton lazySingleton = (LazySingleton) declaredConstructor.newInstance();
     *         System.out.println(lazySingleton == LazySingleton.getLazySingleton()); // false
     *
      */
    private LazySingleton(){
        // 无法解决反射非法创建对象
    }

    public static LazySingleton getLazySingleton() {
        if(lazySingleton == null){
            // 多线程
            synchronized (LazySingleton.class){
                if(lazySingleton == null){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

}
