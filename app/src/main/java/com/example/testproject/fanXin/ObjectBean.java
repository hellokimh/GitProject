package com.example.testproject.fanXin;

public class ObjectBean<T extends Annimals> {
    private T t;
    private String name;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ObjectBean{" +
                "t=" + t +
                ", name='" + name + '\'' +
                '}';
    }
}
