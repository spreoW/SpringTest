package com.controller;

import com.pojo.Student;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangquan
 * @date 2020/12/10
 */
public class UserController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) context.getBean("userService");
        String hello = userService.getUser("张三");
        System.out.println(hello);
    }
}
