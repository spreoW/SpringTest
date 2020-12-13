package com.service.impl;

import com.dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author wangquan
 * @date 2020/12/10
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;
    @Override
    @PostConstruct
    public String getUser(String name) {
        return dao.getUser(name);
    }
}
