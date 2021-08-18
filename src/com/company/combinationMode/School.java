package com.company.combinationMode;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 18190
 * @Date: 2021/8/18  11:26
 * @VERSION 1.0
 *
 * 大学  非叶子节点
 */
public class School extends Combination {
    private final List<College> list = new ArrayList<>();

    public School(String desc) {
        super(desc);
    }

    @Override
    public void add(Combination combination) throws IllegalAccessException {
        College college;
        try {
            college = (College) combination;
            list.add(college);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void remove(Combination combination) throws IllegalAccessException {
        College college;
        try {
            college = (College) combination;
            list.remove(college);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void print() {
        System.out.println(super.desc);
        list.forEach(College::print);
    }
}
