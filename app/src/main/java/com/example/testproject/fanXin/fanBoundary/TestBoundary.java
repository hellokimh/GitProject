package com.example.testproject.fanXin.fanBoundary;

/**
 * 定义泛型类  不知道具体的类型是什么,在初始化的时候声明具体的类型
 *
 * @param <T>
 */
public class TestBoundary<T> {
    private T t;
    private String name;

    public TestBoundary() {
    }

    public TestBoundary(T t, String name) {
        this.t = t;
        this.name = name;
    }

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
}
