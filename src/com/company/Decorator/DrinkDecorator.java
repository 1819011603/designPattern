package com.company.Decorator;

/**
 * @author 18190
 * @Date: 2021/8/16  21:08
 * @VERSION 1.0
 */
public abstract class DrinkDecorator extends Eat{
    private Eat eat;

    public Eat getEat() {
        return eat;
    }

    @Override
    public float cost() {

        return super.getaFloat()+eat.cost();
    }

    public void setEat(Eat eat) {
        this.eat = eat;
    }

    public DrinkDecorator(Eat eat) {
        this.eat = eat;
    }

    @Override
    public String getDesc() {
        String eatDesc = eat.getDesc();
        System.out.println("eatDesc: " + eatDesc);
        // 递归获取desc  debug一下  super.getDesc()只是重载获取装饰器的名字
        // new Cole(eat' = new Cole(new Hamburger())).getDesc(); ==> eat' =  new Cole(eat'' = new Hamburger()).getDesc() ==> eat'' = new Hamburger().getDesc() == "汉堡包"   ==>
        // eat' = new Cole(new Hamburger()).getDesc() ==  super.getDesc() + " " + super.aFloat + " && " + eatDesc  ==    一杯可乐 3.0 && 汉堡包   ==>
        // new Cole(new Cole(new Hamburger())).getDesc() == super.getDesc() + " " + super.aFloat + " && " + eat' ==  一杯可乐 3.0 && 一杯可乐 3.0 && 汉堡包
        return super.getDesc() + " " + super.aFloat + " && " + eatDesc;
    }
}
