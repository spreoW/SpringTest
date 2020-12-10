package com.springtest2.test;

import com.springtest2.scope.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangquan
 * @date 2020/12/9
 */
public class TestScope {

    @Autowired
    private Student student;

    @Test
    public void testScope() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Student student = (Student) context.getBean("student");
        student.setStudy("我在学英语");
        System.out.println(student.getStudy());
        Student student2 = (Student) context.getBean("student");
        System.out.println(student2.getStudy());
        System.out.println(student==student2);
    }
}
