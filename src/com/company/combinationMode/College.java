package com.company.combinationMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 18190
 * @Date: 2021/8/18  11:26
 * @VERSION 1.0
 *
 * 系 非叶子节点
 */
public class College extends Combination {
    private final List<Department> list = new ArrayList<>();

    public College(String desc) {
        super(desc);
    }



    @Override
    public void add(Combination combination) throws IllegalAccessException {
        Department department;
        try {
            department = (Department) combination;
            list.add(department);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void remove(Combination combination) throws IllegalAccessException {
        Department department;
        try {
            department = (Department) combination;
            list.remove(department);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void print() {
        System.out.print(desc);
        for (Department department : list) {
            System.out.print(" ");
            department.print();

        }
        System.out.println();
    }
}
