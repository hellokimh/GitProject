package com.example.testproject.fanXin.fanBoundary;

import android.util.Log;

/**
 * 在项目中使用,类中声明泛型方法或者普通方法中的参数使用泛型类型
 */
public class BeginTestBoundary {
    private String name;

    /**
     * 泛型的上界 ---参数的类型必须是Number或者是Number的子类
     *
     * @param object object
     */
    public void setBoundary(TestBoundary<? extends Number> object) {
        Log.i("TAG", "setBoundary----object = " + object);
    }

    /**
     * 泛型的下界 ---参数的类型必须是Number或者Number的父类
     *
     * @param object object
     */
    public void setBoundarySs(TestBoundary<? super Number> object) {
        Log.i("TAG", "setBoundarySs----object = " + object);
    }

    /**
     * 在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<E>上添加上下边界，即在泛型声明的时候添加
     *
     * @param data
     * @param <E>
     */
    public <E extends Number> void setBoundaryS(E data) {
        Log.i("TAG", "setBoundaryS----data = " + data);
    }

}
