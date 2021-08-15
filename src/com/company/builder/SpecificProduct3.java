package com.company.builder;

import java.math.BigDecimal;

/**
 * @author 18190
 * @Date: 2021/8/15  19:19
 * @VERSION 1.0
 */
public class SpecificProduct3 implements SimpleBuilder {

    @Override
    public SimpleBuilder scene() {
        product.setScene("涂料");
        return this;
    }
    @Override
    public SimpleBuilder brand() {
        product.setBrand("多乐⼠(Dulux)");
        return this;
    }
    @Override
    public SimpleBuilder model() {
        product.setModel("第⼆代");
        return this;
    }
    @Override
    public SimpleBuilder price() {
        product.setPrice(new BigDecimal(719));
        return this;
    }
    @Override
    public SimpleBuilder desc() {
        product.setDesc("多乐⼠是阿克苏诺⻉尔旗下的著名建筑装饰油漆品牌，产品畅销于全球100个国家，每年全球有5000万户家庭使⽤多乐⼠油漆。");
        return this;
    }


}
