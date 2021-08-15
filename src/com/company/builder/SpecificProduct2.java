package com.company.builder;

import java.math.BigDecimal;

/**
 * @author 18190
 * @Date: 2021/8/15  19:19
 * @VERSION 1.0
 */
public class SpecificProduct2 implements Builder {


    @Override
    public void scene() {
        product.setScene("吊顶");
    }
    @Override
    public void brand() {
        product.setBrand("装修公司⾃带");
    }
    @Override
    public void model() {
        product.setModel("二级顶");
    }
    @Override
    public void price() {
        product.setPrice(new BigDecimal(260));
    }
    @Override
    public void desc() {
        product.setDesc("两个层次的吊顶，⼆级吊顶⾼度⼀般就往下吊20cm，要是层⾼很⾼，也可增加 每级的厚度");
    }


}
