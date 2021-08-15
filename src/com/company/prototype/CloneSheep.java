package com.company.prototype;

/**
 * @author 18190
 * @Date: 2021/8/15  16:50
 * @VERSION 1.0
 */
public class CloneSheep implements Cloneable{

    private Sheep sheep;
    private StringBuilder s;
    public CloneSheep(Sheep sheep) {
        this.sheep = sheep;
        s = new StringBuilder("tt");
    }

    @Override
    public String toString() {
        return "CloneSheep{" +
                "sheep=" + sheep +
                ", s='" + s + '\'' +
                '}';
    }

    public StringBuilder getS() {
        return s;
    }

    public void setS(StringBuilder s) {
        this.s = s;
    }

    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }



    public CloneSheep() {
    }



    @Override
    public CloneSheep clone() throws CloneNotSupportedException {
        return (CloneSheep) super.clone();
    }
}
