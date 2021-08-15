package com.company.singleton;

/**
 * @author 18190
 * @Date: 2021/8/9  9:53
 * @VERSION 1.0
 */

/**
 *  静态内部类的加载不需要依附外部类，在使用时才加载
 */
public class InnerStaticSingleton {
    static {
        System.out.println("InnerStaticSingleton init");
    }

    private InnerStaticSingleton(){
        System.out.println("外部类初始化");

    }

    public static InnerStaticSingleton getSingleton(){
        //
        return InnerStatic.SINGLETON;
    }

    // 改成public 只是为了做测试
   public static class InnerStatic{
       static {
            System.out.println("InnerStatic init");
        }

       public final static InnerStaticSingleton SINGLETON = new InnerStaticSingleton();
    }
}
