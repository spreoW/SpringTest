package com.service.impl;

import com.dao.IAccountDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author wangquan
 * @date 2020/12/10
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Value("38")
    private Integer age;

    public Integer getAge() {
        return age;
    }

    @Resource(name = "accountDao2")
    private IAccountDao userDapImpl;

    @Override
    public String getUser(String name) {
        return userDapImpl.getUser(name);
    }
}
