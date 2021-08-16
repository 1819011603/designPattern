package com.company.adapter;

/**
 * @author 18190
 * @Date: 2021/8/16  12:01
 * @VERSION 1.0
 *
 * 优点
 * 更好的复用性：系统需要使用现有的类，而此类的接口不符合系统的需要。那么通过适配器模式就可以让这些功能得到更好的复用。
 * 更好的扩展性：在实现适配器功能的时候，可以扩展自己源的行为（增加方法），从而自然地扩展系统的功能。
 * 缺点
 * 会导致系统紊乱：滥用适配器，会让系统变得非常零乱。例如，明明看到调用的是A接口，其实内部被适配成了B接口的实现，
 * 一个系统如果太多出现这种情况，无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。
 */
public class AdapterTest {
    public static void main(String[] args) {
        // 原先的Adaptee只有一个method方法  但用户也想它具有Target方法 又不能直接修改源代码
        // 那就只能增加一个适配器（增加一个全新类）  用这个类实现Target接口 增加一个Adaptee域既可以解决
        // 利用继承 重写方法将其包装成我们想要的样子
        // 对象适配器  组合方式 更加灵活  本质是继承与重写
        Adapter adapter = new Adapter(new Adaptee());
        adapter.method1();
        adapter.method2();

        adapter = new Adapter(new ExtendAdaptee());
        adapter.method1();
        adapter.method2();

        // 类适配器 单继承  死板  对adpatee的子类无法适配
        Adapter1 adapter1 = new Adapter1();
        adapter1.method1();
        adapter1.method2();

        // 接口适配器  为一个接口提供默认（default）实现，这样子类可以从这个缺省实现进行扩展，而不必从原有接口进行扩展。
        AdapterInterface adapterInterface = new InterfaceAdapter(new Adaptee());
        adapterInterface.method1();
        adapterInterface.method2();
    }
}
