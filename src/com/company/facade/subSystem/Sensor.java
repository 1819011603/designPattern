package com.company.facade.subSystem;

/**
 * @author 18190
 * @Date: 2021/9/1  9:00
 * @VERSION 1.0
 */
public class Sensor
{
    public void Activate()
    {
        System.out.println("Activating the sensor.");
    }

    public void Deactivate()
    {
        System.out.println("Deactivating the sensor.");
    }

    public void Trigger()
    {
        System.out.println("The sensor has triggered.");
    }
}
