package com.example.testproject.projectCeshi;

/**
 * @Author Administrator
 * @Date 2021/1/27-16:40
 * @description cdd$
 */
public class StudentBean {
    private String name;
    private String city;

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

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
