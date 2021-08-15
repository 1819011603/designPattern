package com.company.builder;

/**
 * @author 18190
 * @Date: 2021/8/15  19:12
 * @VERSION 1.0
 */

import java.math.BigDecimal;

/**
 * 建造者模式是为建造一种生存特别复杂的产品(单个)
 * 工厂模式是为了建设不同种类或者不同产品族的多种产品
 * 生产时调用的方法  相似性非常高才用
 */

// 使用abstract class 也可以  并不一定使用接口
public interface Builder {
    Product product = new Product();
    // Product 产品公共的方法
    void scene(); // 场景；地板、地砖、涂料、吊顶
    void brand(); // 品牌
    void model(); // 型号
    void price(); // 价格
    void desc(); // 描述
    default Product getInstance(){
        return product;
    }
}
