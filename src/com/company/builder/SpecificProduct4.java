package com.company.builder;

import java.math.BigDecimal;

/**
 * @author 18190
 * @Date: 2021/8/15  19:19
 * @VERSION 1.0
 */
public class SpecificProduct4 implements SimpleBuilder {

    @Override
    public SimpleBuilder scene() {
        product.setScene("涂料");
        return this;
    }
    @Override
    public SimpleBuilder brand() {
        product.setBrand("⽴邦");
        return this;
    }
    @Override
    public SimpleBuilder model() {
        product.setModel( "默认级别");
        return this;
    }
    @Override
    public SimpleBuilder price() {
        product.setPrice(new BigDecimal(652));
        return this;
    }
    @Override
    public SimpleBuilder desc() {
        product.setDesc("⽴邦始终以开发绿⾊产品、注᯿⾼科技、⾼品质为⽬标，以技术⼒量不断推进科 研和开发，满⾜消费者需求。");
        return this;
    }


}
