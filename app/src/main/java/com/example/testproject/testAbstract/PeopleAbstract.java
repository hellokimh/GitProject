package com.example.testproject.testAbstract;

import android.util.Log;

/**
 * 抽象父类
 */
public abstract class PeopleAbstract {
    /**
     * 私用的属性，只能在本类中访问,子类也不能访问
     */
    private String name;
    /**
     * 公共的属性，子类也不能访问
     */
    public String city;

    /**
     * 私用的方法，只能在本类中访问,子类也不能访问，不能重写
     */
    private void Setting() {
        Log.i("TAG", "love: 我是父类中的Setting方法");
    }

    /**
     * 公共的方法，子类可以重写
     */
    public void love() {
        Log.i("TAG", "love: 我是父类中的love方法");
    }

    /**
     * 抽象方法，子类必须要实现
     */
    abstract void HelloWorld();

}
