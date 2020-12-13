package com.bean;


import java.util.Date;

/**
 * @author w
 * @date 2020/12/13
 */
public class Student {

    private String name;
    private Integer age;
    private Date birthday;

    public Student(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void getStudent(){
        System.out.println(this.name+" : " + age + " : " + birthday);
    }
}
