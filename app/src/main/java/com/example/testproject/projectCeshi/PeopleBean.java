package com.example.testproject.projectCeshi;


/**
 * @Author Administrator
 * @Date 2021/1/27-16:40
 * @description fsfd$
 */
public class PeopleBean {
    private String name;
    private int age;
    private String city;
    private StudentBean studentBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public StudentBean getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", studentBean=" + studentBean +
                '}';
    }
}
