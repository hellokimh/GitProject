package com.example.testproject.fanXin;

import android.util.Log;

public class CatBean extends Annimals {
    private String name;
    private String city;

    public CatBean(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 实现父类的eat()方法
     */
    @Override
    void eat() {
        Log.i("TAG", "CatBean");
    }

    @Override
    public String toString() {
        return "CatBean{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
