package com.example.javabasics.concepts;

public enum EnumSingleton {

    INSTANCE1("Initial class info","Sachit");

    private String info;

    private String name;

    private EnumSingleton(String info, String name) {
        this.info = info;
        this.name = name;
    }

    public EnumSingleton getInstance() {
        return INSTANCE1;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
