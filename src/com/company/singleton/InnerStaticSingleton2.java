package com.company.singleton;

/**
 * @author 18190
 * @Date: 2021/8/9  9:53
 * @VERSION 1.0
 */

import java.io.*;
import java.util.Arrays;
import java.util.UUID;

/**
 *  比较完整了
 */
public class InnerStaticSingleton2 implements Serializable,Cloneable {
    static final long serialVersionUID = 4543215454254L;
    private int s;
    private String s1 = "ass"+UUID.randomUUID().toString();
    static {
        System.out.println("InnerStaticSingleton init");
    }

    private InnerStaticSingleton2(){
        System.out.println("外部类初始化");

        // 防止反射破坏单例
        if(InnerStatic.SINGLETON != null){
            throw new RuntimeException("非法创建对象");
        }
    }

    public static InnerStaticSingleton2 getSingleton(){
        //
        return InnerStatic.SINGLETON;
    }

    // 改成public 只是为了做测试
   public static class InnerStatic{
       static {
            System.out.println("InnerStatic init");
        }

       public final static InnerStaticSingleton2 SINGLETON = new InnerStaticSingleton2();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream os = new ObjectOutputStream(bos)) {
            os.writeObject(this);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        Object o = null;
        try (ObjectInputStream ois = new ObjectInputStream(bis)) {
            o = ois.readObject();

        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
        return o;
    }

    public Object readResolve(){
        return InnerStatic.SINGLETON;

    }
}
