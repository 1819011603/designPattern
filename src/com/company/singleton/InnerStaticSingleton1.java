package com.company.singleton;

/**
 * @author 18190
 * @Date: 2021/8/9  9:53
 * @VERSION 1.0
 */

/**
 *  静态内部类的加载不需要依附外部类，在使用时才加载
 */
public class InnerStaticSingleton1 {
    static {
        System.out.println("InnerStaticSingleton init");
    }

    private InnerStaticSingleton1(){
        System.out.println("外部类初始化");

        // 防止反射破坏单例
        if(InnerStatic.SINGLETON != null){
            throw new RuntimeException("非法创建对象");
        }
    }

    public static InnerStaticSingleton1 getSingleton(){
        //
        return InnerStatic.SINGLETON;
    }

    // 改成public 只是为了做测试
   public static class InnerStatic{
       static {
            System.out.println("InnerStatic init");
        }

       public final static InnerStaticSingleton1 SINGLETON = new InnerStaticSingleton1();
    }
}
