package HW6;

import java.awt.*;

public class Notebook {
    private int ram;
    private int hdd;
    private String os;
    private String color;

    public Notebook(int ram, int hdd, String os, String color){
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "ram=" + ram +
                ", hdd=" + hdd +
                ", os='" + os + '\'' +
                ", color=" + color +
                '}';
    }
}
