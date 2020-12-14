package com.controller;

import com.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangquan
 * @date 2020/12/10
 */
public class AccountController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountServiceImpl userService = (AccountServiceImpl) context.getBean("accountService");
        String hello = userService.getUser("张三");
        System.out.println(hello);
    }
}
