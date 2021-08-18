package com.company.combinationMode;

/**
 * @author 18190
 * @Date: 2021/8/18  11:22
 * @VERSION 1.0
 *
 * 存在很多“部分-整体”的关系
 *
 *
 * 抽象构件（Component）角色：它的主要作用是为树叶构件和树枝构件声明公共接口，并实现它们的默认行为。在透明式的组合模式中抽象构件还声明访问和管理子类的接口；在安全式的组合模式中不声明访问和管理子类的接口，管理工作由树枝构件完成。（总的抽象类或接口，定义一些通用的方法，比如新增、删除）
 * 树叶构件（Leaf）角色：是组合中的叶节点对象，它没有子节点，用于继承或实现抽象构件。
 * 树枝构件（Composite）角色 / 中间构件：是组合中的分支节点对象，它有子节点，用于继承和实现抽象构件。它的主要作用是存储和管理子部件，通常包含 Add()、Remove()、GetChild() 等方法。
 *
 * 组合模式分为透明式的组合模式和安全式的组合模式。
 *
 * 透明方式
 * 在该方式中，由于抽象构件声明了所有子类中的全部方法，所以客户端无须区别树叶对象和树枝对象，对客户端来说是透明的。但其缺点是：树叶构件本来没有 Add()、Remove() 及 GetChild() 方法，却要实现它们（空实现或抛异常），这样会带来一些安全性问题。其结构图如图 1 所示。
 *
 * 安全方式
 * 在该方式中，将管理子构件的方法移到树枝构件中，抽象构件和树叶构件没有对子对象的管理方法，这样就避免了上一种方式的安全性问题，但由于叶子和分支有不同的接口，客户端在调用时要知道树叶对象和树枝对象的存在，所以失去了透明性
 *
 */
public abstract class Combination {
    protected String desc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Combination that = (Combination) o;

        return desc != null ? desc.equals(that.desc) : that.desc == null;
    }

    @Override
    public int hashCode() {
        return desc != null ? desc.hashCode() : 0;
    }

    public Combination(String desc) {
        this.desc = desc;
    }

    public  void add(Combination combination) throws IllegalAccessException {
        throw new IllegalAccessException("add 非法访问");
    }

    public void remove(Combination combination) throws IllegalAccessException {
        throw new IllegalAccessException("remove 非法访问");
    }

    public abstract void print();

}
