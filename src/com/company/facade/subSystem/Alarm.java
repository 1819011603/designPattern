package com.company.facade.subSystem;

/**
 * @author 18190
 * @Date: 2021/9/1  9:00
 * @VERSION 1.0
 */
public class Alarm
{

    public void Activate()
    {
        System.out.println("Activating the alarm.");
    }

    public void Deactivate()
    {
        System.out.println("Deactivating the alarm.");
    }

    public void Ring()
    {
        System.out.println("Ringing the alarm.");
    }

    public void StopRing()
    {
        System.out.println("Stop the alarm.");
    }
}
