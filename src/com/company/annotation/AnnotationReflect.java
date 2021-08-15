package com.company.annotation;

import org.junit.Test;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 18190
 * @Date: 2021/8/14  16:13
 * @VERSION 1.0
 */
public class AnnotationReflect {

    @Test
    public void testAnnotation() throws ClassNotFoundException {
        Class c1 = Class.forName("com.company.annotation.JavaBean");
        Annotation[] annotations = c1.getAnnotations();
        System.out.println(Arrays.toString(annotations));
        databaseName databaseName = (databaseName)c1.getAnnotation(databaseName.class);
        System.out.println(databaseName);
        System.out.println(databaseName.value());

        Field[] declaredFields = c1.getDeclaredFields();
//        Arrays.stream(declaredFields).map(a -> (databaseColumn)a.getAnnotations()[0]).forEach(c->{
//            System.out.println(c);
//            System.out.println(c.columnName());
//            System.out.println(c.columnType());
//            System.out.println(c.length());
//        });
        System.out.println("===============================");
        Arrays.stream(declaredFields).map(a -> a.getAnnotation(databaseColumn.class)).forEach(c->{
            System.out.println(c);
            if(c!=null){
                System.out.println(c.columnName());
                System.out.println(c.columnType());
                System.out.println(c.length());
            }

        });



    }
}


@databaseName("db_student")
class JavaBean{
    @databaseColumn(columnName = "id",columnType = "int")
    private Integer id;
//    @databaseColumn(columnName = "age",columnType = "int")
    private Integer age;
    @databaseColumn(columnName = "name",length = 100)
    private String name;

    @databaseColumn(columnName = "teacher_id")
    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        teacherId = teacherId;
    }

    public JavaBean() {
    }

    public JavaBean(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }


    @Override
    public String toString() {
        return "JavaBean{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", TeacherId='" + teacherId + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * @author 18190
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface databaseName{
    String value();
}


/**
 * @author 18190
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface databaseColumn{
    String columnName();
    String columnType() default "varchar";
    int length() default 10;
}