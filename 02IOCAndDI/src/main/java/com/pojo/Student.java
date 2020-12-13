package com.pojo;

/**
 * @author w
 * @date 2020/12/11
 */
public class Student {
    private String name;
    public Student(){
        System.out.println("Student被初始化。。。");
    }
    public Student(String name){
        this.name = name;
        System.out.println(name + ": 开始学习");
    }

    public void sayHello(){
        System.out.println("hello: " + name);
    }
}
