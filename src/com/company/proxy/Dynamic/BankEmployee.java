package com.company.proxy.Dynamic;

import com.company.Decorator.Bread;
import com.company.prototype.AsiaSheep;
import com.company.prototype.CloneSheep;
import com.company.prototype.Sheep;

import java.io.InputStream;

/**
 * @author 18190
 * @Date: 2021/9/6  16:31
 * @VERSION 1.0
 */
public class BankEmployee implements Employee,Fine,Third{




    @Override
    public void work(String w) {
        System.out.println("bank work! " + w);
    }

    @Override
    public int hhh(String m, int i, String l) {
        System.out.println("hhh " + m + " " +i + " " + l);

        return 0;
    }

    @Override
    public void yyy() {
        System.out.println("yyy");
    }

    @Override
    public void ttt(AsiaSheep asiaSheep, InputStream inputStream) {

    }

    @Override
    public Bread fineyyy() {
        return new Bread();
    }

    @Override
    public void finettt(AsiaSheep asiaSheep, InputStream inputStream) {

    }

    @Override
    public Character ccc(Double d, long l) {
        return null;
    }

    @Override
    public Byte[] bbb(Double[] d, Integer i) {
        return new Byte[0];
    }

    @Override
    public Sheep[] fdw(CloneSheep[] cloneSheep) {
        return new Sheep[0];
    }
}
