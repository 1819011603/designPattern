package com.company.combinationMode;

import jdk.nashorn.internal.ir.CallNode;

/**
 * @author 18190
 * @Date: 2021/8/18  11:42
 * @VERSION 1.0
 *
 * 组合模式： 叶子节点与非叶子节点
 *
 * 在现实生活中，存在很多“部分-整体”的关系，例如，大学中的部门与学院、总公司中的部门与分公司、
 * 学习用品中的书与书包、生活用品中的衣服与衣柜、以及厨房中的锅碗瓢盆等。在软件开发中也是这样，
 * 例如，文件系统中的文件与文件夹、窗体程序中的简单控件与容器控件等。对这些简单对象与复合对象的处理，如果用组合模式来实现会很方便。
 *
 *
 *，其实根节点和树枝节点本质上属于同一种数据类型，可以作为容器使用；而叶子节点与树枝节点在语义上不属于用一种类型。但是在组合模式中，会把树枝节点和叶子节点看作属于同一种数据类型（用统一接口定义），让它们具备一致行为。
 *
 * 这样，在组合模式中，整个树形结构中的对象都属于同一种类型，带来的好处就是用户不需要辨别是树枝节点还是叶子节点，可以直接进行操作，给用户的使用带来极大的便利。
 *
 * 组合模式的主要优点有：
 * 组合模式使得客户端代码可以一致地处理单个对象和组合对象，无须关心自己处理的是单个对象，还是组合对象，这简化了客户端代码；
 * 更容易在组合体内加入新的对象，客户端不会因为加入了新的对象而更改源代码，满足“开闭原则”；
 *
 * 其主要缺点是：
 * 设计较复杂，客户端需要花更多时间理清类之间的层次关系；
 * 不容易限制容器中的构件；
 * 不容易用继承的方法来增加构件的新功能；
 */
public class CombinationTest {
    public static void main(String[] args) throws IllegalAccessException {
        School school = new School("中南大学");
        College college = new College("计算机系");
        College college1 = new College("法学系");
        school.add(college);
        school.add(college1);

        Department department = new Department("计算机技术");
        Department department1 = new Department("软件工程");
        college.add(department);
        college.add(department1);

        department = new Department("中国法学");
        department1 = new Department("刑法");
        Department department2 = new Department("商业法");
        Department department3 = new Department("宪法");
        college1.add(department);
        college1.add(department1);
        college1.add(department2);
        college1.add(department3);
        school.print();


        department3 = new Department("宪法");
        college1.remove(department3);
        school.print();





    }
}
