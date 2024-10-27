package com.example.javabasics.concepts;



public class SingletonExample {

    private static final SingletonExample instance = new SingletonExample();
    private String info="Infosys";

    private SingletonExample(){

    }

    public static SingletonExample getObject(){
        return instance;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
