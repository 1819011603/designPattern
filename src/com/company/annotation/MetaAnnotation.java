package com.company.annotation;

import java.lang.annotation.*;

/**
 * @author 18190
 * @Date: 2021/8/14  14:44
 * @VERSION 1.0
 */

@SuppressWarnings(value = {"all"})
/**
 * 元注解
 * @Target  目标 用于描述注解的使用范围  被描述的注解可以用在什么地方  类、方法、构造器
 * @Retention  保留   表示需要在什么级别保存该注释信息 用于描述注解的生命周期  (source  < class  < runtime)
 * @Documented  说明该注解将被包含在javadoc中
 * @Inherited 说明子类可以继承父类中的该注解
 */
@metaAnnotation
public class MetaAnnotation {


    @metaAnnotation
    private MetaAnnotation(){

    }

    @metaAnnotation
    public void test(){

    }
}


/**
 * @author 18190
 */
@Target(value = {ElementType.METHOD,ElementType.TYPE,ElementType.CONSTRUCTOR})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface metaAnnotation{

}