package com.company.builder;

import java.math.BigDecimal;

/**
 * @author 18190
 * @Date: 2021/8/15  19:17
 * @VERSION 1.0
 */
public class SpecificProduct1 implements Builder {

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
        product.setModel("⼀级顶");
    }
    @Override
    public void price() {
        product.setPrice(new BigDecimal(260));
    }
    @Override
    public void desc() {
        product.setDesc("造型只做低⼀级，只有⼀个层次的吊顶，⼀般离顶120-150mm");
    }


}
