package com.controller;

import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangquan
 * @date 2020/12/10
 */
public class UserController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        String hello = userService.getUser("张三");
        System.out.println(userService.getAge());
        System.out.println(hello);
    }
}
