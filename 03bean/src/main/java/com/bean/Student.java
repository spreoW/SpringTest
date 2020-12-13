package com.bean;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author w
 * @date 2020/12/13
 */
public class Student implements BeanNameAware {
    private String name;

    public Student(){
        System.out.println("1、调用构造方法初始化Bena");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("3、BeanNameAware设置BeanName：" + name);
    }

    public void setName(String name) {
        System.out.println("2、设置对象属性setName()..");
        this.name = name;
    }

    /**
     * Bean的使用
     */
    public void study() {
        System.out.println("7、Student这个Bean：使用,调用study()方法，此时我的名字：" + this.name);
    }

    public void initMethod(){
        System.out.println("5、设置Bean的初始化方法..");
    }

    public void destroyMethod(){
        System.out.println("8、设置Bean的销毁方法..");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
