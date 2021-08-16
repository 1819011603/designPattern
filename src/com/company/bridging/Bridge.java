package com.company.bridging;

/**
 * @author 18190
 * @Date: 2021/8/16  19:57
 * @VERSION 1.0
 *
 * 一个类需要在两个以上维度扩展，采用继承方式会导致子类数量过多
 *
 * 将抽象部分与实现部分分离，使其都可以独立变化
 * 桥接模式不是将两个不相干的类链接，而是将一个需要多维度变化的类拆分成抽象部分和实现部分，并且在抽象层对两者做组合关联，是用组合的方式来解决继承的问题。
 * 举个例子，如果一个类在两个维度分别有m和n种变化，采用继承的方式就需要扩展出m*n个子类，且一个维度每增加一种变化就多出另一个维度变化总数的子类；
 * 如果将两个维度拆分再组合，加起来也只有m+n个子类，且每个维度独立扩展，一个维度增加一种变化只需要增加１个子类。
 *
 *
 * 桥接模式是一种结构型设计模式，根据最小继承原则，将各个变化部分分离，从而实现独立变化互不干涉，但又在更高的抽象层实现组合以保证各子类能动态结合。
 *
 *
 * 假设一个类有两种维度，一种是品牌，一种是手机是翻盖、触屏  可以组成n*m中不同的手机
 * 选一个维度进行抽象   本次选的是品牌抽象  也可以选择翻盖、触屏抽象
 *
 * 1个Implement：抽象出来的接口
 * n个Implement实现类： 接口具体实现类，本次是 xiaomi、ViVo、HUAWEI
 * Abstraction： 桥，包含一个Implement引用，通过构造函数初始化。  可以有n中不同的实现类（Abstraction中含有Implement引用）
 * m个Abstraction实现类：  一个Abstraction实现类可以与n中Implement实现类组成n个不同的手机 m个Abstraction实现类可以组成n*m个不同的手机
 *                        总的实现类为 n+m   (3 + 2 == 5)
 * 而且增加一个Abstraction/Implement实现类也特别方便  只需增加一个类即可
 *
 *
 */
public class Bridge {

    public static void main(String[] args) {
        Phone folderPhone = new FolderPhoneImpl(new XiaoMi());
        folderPhone.open();
        folderPhone.call();
        folderPhone.close();
        folderPhone = new FolderPhoneImpl(new HUAWEI());
        folderPhone.open();
        folderPhone.call();
        folderPhone.close();
        folderPhone = new FolderPhoneImpl(new ViVo());
        folderPhone.open();
        folderPhone.call();
        folderPhone.close();

        System.out.println("========================================");

        Phone upRightPhone = new UpRightPhoneImpl(new XiaoMi());
        upRightPhone.open();
        upRightPhone.call();
        upRightPhone.close();
        upRightPhone = new UpRightPhoneImpl(new HUAWEI());
        upRightPhone.open();
        upRightPhone.call();
        upRightPhone.close();
        upRightPhone = new UpRightPhoneImpl(new ViVo());
        upRightPhone.open();
        upRightPhone.call();
        upRightPhone.close();
    }
}
