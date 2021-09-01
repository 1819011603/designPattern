package com.company.facade;

/**
 * @author 18190
 * @Date: 2021/8/18  15:29
 * @VERSION 1.0
 */
public class FacadeClient {
    private static Facade security;

    public static void main(String[] args) {
        security = new Facade();
        security.Activate();

        System.out.println("\n---------------------\n");

        security.Deactivate();
    }

}
