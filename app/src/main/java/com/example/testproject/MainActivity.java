package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.testproject.fanXin.CatBean;
import com.example.testproject.fanXin.FanXinBean;
import com.example.testproject.fanXin.ObjectBean;
import com.example.testproject.fanXin.Student;
import com.example.testproject.fanXin.fanBoundary.BeginTestBoundary;
import com.example.testproject.fanXin.fanBoundary.TestBoundary;
import com.example.testproject.maoToKotlin.MapTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView tvHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHttp = (TextView) findViewById(R.id.tv_show_url);
        //initAbstract();
        //initFanXin();
        List<Student> list = new ArrayList<>();
        initFanXinTongPeiFu();
       /* initFanBoundary();
        initList();*/
        //BuildConfig
        initMap();
    }

    private void initMap() {
        MapTest mapTest = new MapTest();
        //mapTest.testMap();
    }

    private void initList() {
        List<String> stringList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        //setList(stringList);//编译失败  List<String> 是List的子类,并不能看成是 List<Object> 的子类
        setList(objectList);

        setListOne(objectList);
        setListOne(stringList);
    }

    public void setList(List<Object> objects) {
    }

    //通配符的使用,传入任何类型的参数
    public void setListOne(List<?> objects) {
    }

    //泛型的边界(上界和下界)
    private void initFanBoundary() {
        //申明Integer类型的TestBoundary
        TestBoundary<Integer> testBoundary = new TestBoundary<>();
        //声明Long类型的TestBoundary
        TestBoundary<Long> testBoundary1 = new TestBoundary<>();
        //声明String类型的TestBoundary
        TestBoundary<String> testBoundary2 = new TestBoundary<>();
        BeginTestBoundary beginTestBoundary = new BeginTestBoundary();
        //JVM编译通过(TestBoundary类中申明的是Integer类型的,Integer是Number的子类)
        beginTestBoundary.setBoundary(testBoundary);
        //JVM编译通过(TestBoundary类中申明的是Long类型的,Long是Number的子类)
        beginTestBoundary.setBoundary(testBoundary1);
        //JVM编译不通过(TestBoundary类中申明的是String类型的,但是Sting并不是Number的子类)
        //beginTestBoundary.setBoundary(testBoundary2);

        //JVM编译不能通过(testBoundary申明的是Integer类型,而调用的方法中需要是Number或者Number的父类类型)
        //beginTestBoundary.setBoundarySs(testBoundary);
        TestBoundary<Number> testBoundary3 = new TestBoundary<>();
        //JVM编译通过(TestBoundary申明的是Number,而调用的方法中是需要Number或者Number的父类类型)
        beginTestBoundary.setBoundarySs(testBoundary3);
    }

    private void initFanXinTongPeiFu() {
        FanXinBean<Number> fanXinBean = new FanXinBean<>();
        FanXinBean<Integer> fanXinBean1 = new FanXinBean<>();
        fanXinBean.setShowValue(fanXinBean);
        fanXinBean.setShowValue(fanXinBean1);
        //获取fanXinBean的class类型
        Class<? extends FanXinBean> className = fanXinBean.getClass();
        Log.i("TAG", "className: " + className);//--------class com.example.testproject.FanXin.FanXinBean
        //获取fanXinBean1的class类型
        Class<? extends FanXinBean> classNameTwo = fanXinBean1.getClass();
        Log.i("TAG", "classNameTwo: " + classNameTwo);//------class com.example.testproject.FanXin.FanXinBean

        fanXinBean.showE("生产环境");
        String data = fanXinBean.showString("data");
        Log.i("TAG", "initFanXinTongPeiFu: " + data);
        String[] strings = new String[]{"生产环境", "测试环境"};
        String[] strings1 = fanXinBean.getArray(strings);
        Log.i("TAG", "initFanXinTongPeiFu: " + strings1.length);
        fanXinBean.printMsg("生产环境", 192.16, 10);
        fanXinBean.printMsg2("生产环境", 192.16, 10);
    }

    private void initFanXin() {
        /*FanXinBean<String> fanXinBean = new FanXinBean<>();
        fanXinBean.setT("FanXinT");
        String name = fanXinBean.getT();
        Log.i("TAG", "name=" + name);
        Student student = new Student("Ak", "MC");
        FanXinBean<Student> fanXinBean1 = new FanXinBean<>();
        fanXinBean1.setT(student);
        Student student1 = fanXinBean1.getT();
        Log.i("TAG", "name=" + student1.toString());*/
        ObjectBean<CatBean> objectBean = new ObjectBean<>();
        CatBean catBean = new CatBean("cat", "bj");
        objectBean.setT(catBean);
        Log.i("TAG", "name=" + catBean.toString());
    }

    private void initAbstract() {
        /*People people = new People();
        people.ChiFan();
        people.love();
        String mCity = people.city;
        Log.i("TAG", "mCity=" + mCity);*/
       /* Man man = new Man();
        man.love();*/
    }

    public <E> Set<E> setData(Set<E> set, Set<E> s) {
        set.addAll(s);
        return set;
    }

    public <E> E setString(E data, List<E> stringData) {
        E name = null;
        for (int i = 0; i < stringData.size(); i++) {
            if (stringData.size() == 0) {
                stringData.add(data);
            }
            name = stringData.get(0);
        }
        return name;
    }
}