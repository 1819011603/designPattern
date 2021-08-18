package com.company.combinationMode;

/**
 * @author 18190
 * @Date: 2021/8/18  11:27
 * @VERSION 1.0
 *
 * 专业 叶子节点
 * 叶子节点并没有重写add remove方法
 * 并且没有List数组 因为已经是叶子 没有包含关系了
 */
public class Department extends Combination {


    public Department(String desc) {

        super(desc);
    }

    @Override
    public void print() {
        System.out.print(desc);
    }
}
