package com.company.annotation;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 18190
 * @Date: 2021/8/14  14:59
 * @VERSION 1.0
 * 自定义注解
 */
public class CustomizeAnnotation {

    @Test
    @myAnnotation1
    @myAnnotation(name = "zzl",age = 10,id = 0)
    public void test01(){


        System.out.println(this.getClass().getClassLoader());

        System.out.println(Object.class.getClassLoader());

        System.out.println(System.getProperty("java.class.path"));
//        C:\Program Files\JetBrains\IntelliJ IDEA 2020.2.2\lib\idea_rt.jar;
//        C:\Program Files\JetBrains\IntelliJ IDEA 2020.2.2\plugins\junit\lib\junit5-rt.jar;
//        C:\Program Files\JetBrains\IntelliJ IDEA 2020.2.2\plugins\junit\lib\junit-rt.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\charsets.jar;C:\Java\jdk1.8.0_251\jre\lib\deploy.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\access-bridge-64.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\cldrdata.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\dnsns.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\jaccess.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\jfxrt.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\localedata.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\nashorn.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\sunec.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\sunjce_provider.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\sunmscapi.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\sunpkcs11.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\ext\zipfs.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\javaws.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\jce.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\jfr.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\jfxswt.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\jsse.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\management-agent.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\plugin.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\resources.jar;
//        C:\Java\jdk1.8.0_251\jre\lib\rt.jar;
//        E:\Project\designPattern\target\classes;
//        D:\tools\repository\junit\junit\4.12\junit-4.12.jar;
//        D:\tools\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;
//        D:\tools\repository\org\apache\commons\commons-lang3\3.8.1\commons-lang3-3.8.1.jar
//        D:\tools\repository\commons-beanutils\commons-beanutils\1.9.4\commons-beanutils-1.9.4.jar;
//        D:\tools\repository\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;
//        D:\tools\repository\commons-collections\commons-collections\3.2.1\commons-collections-3.2.1.jar;
//        D:\tools\repository\commons-lang\commons-lang\2.6\commons-lang-2.6.jar;
//        D:\tools\repository\io\protostuff\protostuff-core\1.7.4\protostuff-core-1.7.4.jar;
//        D:\tools\repository\io\protostuff\protostuff-api\1.7.4\protostuff-api-1.7.4.jar;
//        D:\tools\repository\io\protostuff\protostuff-runtime\1.7.4\protostuff-runtime-1.7.4.jar;
//        D:\tools\repository\io\protostuff\protostuff-collectionschema\1.7.4\protostuff-collectionschema-1.7.4.jar;
//        C:\Program Files\JetBrains\IntelliJ IDEA 2020.2.2\lib\idea_rt.jar


    }

}


/**
 * @author 18190
 */
@Target(value = {ElementType.METHOD} )
@Retention(RetentionPolicy.RUNTIME)
@interface myAnnotation{
    // 没有默认值必须要赋值
    String name() default "";
    int age() default 0;
    int id() default -1;

    String[] schools() default {"湖大","中南"};
}

/**
 * @author 18190
 */
@Target(value = {ElementType.METHOD} )
@Retention(RetentionPolicy.RUNTIME)
@interface myAnnotation1{
    String value() default "";
}
