package com.example.testproject.fanXin;

import android.util.Log;

/**
 * 泛型声明
 *
 * @param <T>
 */
public class FanXinBean<T> {
    private T t;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    /**
     * 通配符？
     *
     * @param numberFanXinBean
     */
    public void setShowValue(FanXinBean<?> numberFanXinBean) {

    }

    /**
     * 泛型方法,类型申明为<T>
     *
     * @param tFanXinBean
     * @param <T>
     */
    public <T> void showKeyString(FanXinBean<T> tFanXinBean) {
        //return "生产环境";
        Log.i("TAG", "showKeyString");
    }

    /**
     * 泛型方法,类型声明为<E>,即使类中没有声明,编译器还是可以辨识出来的,无返回值
     *
     * @param data
     * @param <E>
     */
    public <E> void showE(E data) {
        Log.i("TAG", "showE");
    }

    /**
     * 泛型方法,类型申明为<E>,即使类中没有声明,编译器还是可以辨识出来,返回值为String类型
     *
     * @param data
     * @param <E>
     * @return
     */
    public <E> String showString(E data) {
        return "生产环境";
    }

    /**
     * 泛型方法,类型声明为<E>,即使类中没有声明,编译器还是可以辨识出来,返回值为E类型的数组
     *
     * @param data
     * @param <E>
     * @return
     */
    public <E> E[] getArray(E[] data) {
        return data;
    }

    /**
     * 泛型方法和多参数的使用一
     *
     * @param data
     * @param <E>
     */
    public <E> void printMsg(E... data) {
        for (int i = 0; i < data.length; i++) {
            Log.i("TAG", "printMsg: i=" + i);
        }
    }

    /**
     * 泛型方法和多参数的使用二
     *
     * @param data
     * @param <E>
     */
    public <E> void printMsg2(E data, E data2, E data3) {
        Log.i("TAG", "printMsg: data=" + data);
        Log.i("TAG", "printMsg: data2=" + data2);
        Log.i("TAG", "printMsg: data3=" + data3);

    }


    @Override
    public String toString() {
        return "FanXinBean{" +
                "t=" + t +
                ", name='" + name + '\'' +
                '}';
    }
}
