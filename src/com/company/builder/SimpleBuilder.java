package com.company.builder;

import java.math.BigDecimal;

/**
 * @author 18190
 * @Date: 2021/8/15  19:52
 * @VERSION 1.0
 */
public interface SimpleBuilder {
    Product product = new Product();
    // 返回SimpleBuilder只是为了链式调用
    SimpleBuilder scene(); // 场景；地板、地砖、涂料、吊顶
    SimpleBuilder brand(); // 品牌
    SimpleBuilder model(); // 型号
    SimpleBuilder price(); // 价格
    SimpleBuilder desc(); // 描述

    default Product getInstance(){
        return product;
    }

}
