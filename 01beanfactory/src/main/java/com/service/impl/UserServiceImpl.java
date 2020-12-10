package com.service.impl;

import com.dao.UserDao;
import com.factory.BeanFactory;
import com.service.UserService;

/**
 * @author wangquan
 * @date 2020/12/10
 */
public class UserServiceImpl implements UserService {
    UserDao bean = (UserDao) BeanFactory.getBean("userDao");
    @Override
    public String getUser(String name) {
        return bean.getUser(name);
    }
}
