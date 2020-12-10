package com.controller;

import com.dao.UserDao;
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
        UserDao userDao = (UserDao) context.getBean("userDao");
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userDao);
        System.out.println(userService);
    }
}
