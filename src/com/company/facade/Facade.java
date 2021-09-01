package com.company.facade;

import com.company.facade.subSystem.Alarm;
import com.company.facade.subSystem.Camera;
import com.company.facade.subSystem.Light;
import com.company.facade.subSystem.Sensor;

/**
 * @author 18190
 * @Date: 2021/8/18  15:28
 * @VERSION 1.0
 *
 * 提供统一的调动 聚合所有的子系统
 * Facade门面角色：客户端通过调用该角色访问系统，此角色知道子系统的所有功能和责任。一般情况下，本角色会将所有客户端发来的请求委派到相应的子系统中去，也就是该角色没有实际的业务逻辑，只是一个委托类。
 * Subsystem子系统角色：可以同时 有一个或者多个子系统。每个子系统都不是一个单独的类，而是一个类的集合，子系统并不知道门面的存在
 *
 *
 * 门面模式的优点
 * 减少系统的相互依赖，所有的依赖都是对门面对象的依赖，与子系统无关。
 * 提高了灵活性，不管子系统内如何变化，只要不影响到门面对象就无需对上层代码进行调整。
 * 提高安全性，想让客户端访问系统的哪些业务就开通哪些逻辑，客户端无法访问不在门面模式中开通的方法。
 *
 *
 * 门面模式的缺点
 * 门面模式最大的缺点就是不符合开闭原则，对修改关闭，对扩展开放。如果出现增加或者删除功能，只能修改门面，而不能通过继承或者覆写的方式修正。
 */
public class Facade {
    private static Camera camera1, camera2;
    private static Light light1, light2, light3;
    private static Sensor sensor;
    private static Alarm alarm;

    static {
        camera1 = new Camera();
        camera2 = new Camera();
        light1 = new Light();
        light2 = new Light();
        light3 = new Light();
        sensor = new Sensor();
        alarm = new Alarm();
    }

    public void Activate()
    {
        camera1.TurnOn();
        camera2.TurnOn();
        light1.TurnOn();
        light2.TurnOn();
        light3.TurnOn();
        sensor.Activate();
        alarm.Activate();
    }

    public void Deactivate()
    {
        camera1.TurnOff();
        camera2.TurnOff();
        light1.TurnOff();
        light2.TurnOff();
        light3.TurnOff();
        sensor.Deactivate();
        alarm.Deactivate();
    }
}
