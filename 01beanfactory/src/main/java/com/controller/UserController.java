package com.controller;

import com.factory.BeanFactory;
import com.service.UserService;

/**
 * @author wangquan
 * @date 2020/12/10
 */
public class UserController {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            UserService bean = (UserService) BeanFactory.getBean("userService");
            System.out.println(bean);
            System.out.println(bean.getUser("张三"));
        }
    }
}
