package com.liu.interfaceDesign;

interface Target{
    double getVlaue();
}
class Adaptee{
    double x  = Math.random()*10;
    public double getX(){
        return x;
    }
}
public class Adapter  extends Adaptee implements Target{
    @Override
    public double getVlaue() {
        return getX();
    }
    public static void main(String [] args){
        Adapter adapter = new Adapter();
        System.out.println(adapter.getX());
        System.out.println(adapter.getVlaue());
    }
}
