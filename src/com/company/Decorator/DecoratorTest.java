package com.company.Decorator;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author 18190
 * @Date: 2021/8/16  20:39
 * @VERSION 1.0
 *
 * 装饰器只有一个主体 但是可以被Decorator重复多次修饰
 */
public class DecoratorTest {
    public static void main(String[] args) throws IOException {

        // 主体
        Eat eat = new Hamburger();
        // 主体+一个装饰器cola
        DrinkDecorator cola = new Cola(eat);
        System.out.println(cola.getDesc());
        System.out.println(cola.cost());

        // 主体+两个装饰器cola
        cola = new Cola(cola);
        System.out.println(cola.getDesc());
        System.out.println(cola.cost());
        // 主体+两个装饰器cola +一个装饰器milk
        DrinkDecorator milk = new Milk(cola);
        System.out.println(milk.getDesc());
        System.out.println(milk.cost());

        // 主体+两个装饰器cola +一个装饰器milk  + 一个装饰器tea
        DrinkDecorator tea = new Tea(milk);
        System.out.println(tea.getDesc());
        System.out.println(tea.cost());




        System.out.println("=================================");
        // 主体
        eat = new Bread();
        // 主体+一个装饰器cola
         cola = new Cola(eat);
        System.out.println(cola.getDesc());
        System.out.println(cola.cost());

        // 主体+两个装饰器cola
        cola = new Cola(cola);
        System.out.println(cola.getDesc());
        System.out.println(cola.cost());
        // 主体+两个装饰器cola +一个装饰器milk
        milk = new Milk(cola);
        System.out.println(milk.getDesc());
        System.out.println(milk.cost());

        // 主体+两个装饰器cola +一个装饰器milk  + 一个装饰器tea
        tea = new Tea(milk);
        System.out.println(tea.getDesc());
        System.out.println(tea.cost());



//        IODecorator();
    }

    private static void IODecorator() throws IOException {
        // InputStream 最开始的接口  FileInputStream、StringBufferInputStream是InputStream的具体实现类
        InputStream inputStream = new FileInputStream("E:\\Project\\designPattern\\src\\com\\company\\Decorator\\DecoratorTest.java");


        FilterInputStream filterInputStream = new BufferedInputStream(inputStream);

        // FilterInputStream是继承InputStream的实现类 为Decorator
        // DataInputStream、BufferedInputStream为Decorator实现类,这些Decorator用来装饰 FileInputStream、StringBufferInputStream这些主体，主体只有一个。
        FilterInputStream dataInputStream = new DataInputStream(filterInputStream);
        // 可以被多次装饰
        dataInputStream = new DataInputStream(dataInputStream);
        dataInputStream = new DataInputStream(dataInputStream);
        dataInputStream = new BufferedInputStream(dataInputStream);
        // 数组小了 就会出现临界问题  128
        byte[] bytes = new byte[4096];
        int read = dataInputStream.read(bytes);
        while (read != -1){
            System.out.print(new String(bytes, StandardCharsets.UTF_8));
            read = dataInputStream.read(bytes);
        }
        System.out.println();
        inputStream.close();
    }

}
