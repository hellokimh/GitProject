package com.example.testproject.testAbstract;

import android.util.Log;

/**
 * 子类继承父类
 */
public class People extends PeopleAbstract {
    /**
     * 必须实现父类中的抽象方法
     */
    @Override
    void HelloWorld() {
        Log.i("TAG", "love: 我是实现父类中的HelloWorld方法");
    }

    public void ChiFan() {
        Log.i("TAG", "ChiFan: 我是子类中的ChiFan方法");
        //父类中的属性可以用  这里给其赋值
        city = "maCheng";
    }

    /**
     * 重新父类中love方法
     */
    @Override
    public void love() {
        Log.i("TAG", "love: 我是重新父类中的love方法");
    }
}
