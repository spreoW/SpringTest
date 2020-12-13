package com.controller;

import com.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author w
 * @date 2020/12/13
 */
public class StudentController {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }
}
