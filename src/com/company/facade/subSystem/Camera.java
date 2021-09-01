package com.company.facade.subSystem;

import java.io.Console;

/**
 * @author 18190
 * @Date: 2021/9/1  8:56
 * @VERSION 1.0
 */
public class Camera {
    public void TurnOn()
    {
        System.out.println("Turning on the camera.");
    }

    public void TurnOff()
    {
        System.out.println("Turning off the camera.");
    }

    public void Rotate(int degrees)
    {
        System.out.printf("Rotating the camera by {0} degrees.\n", degrees);
    }
}
