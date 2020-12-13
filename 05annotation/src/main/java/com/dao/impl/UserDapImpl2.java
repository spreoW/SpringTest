package com.dao.impl;

import com.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author wangquan
 * @date 2020/12/10
 */
@Repository
public class UserDapImpl2 implements UserDao {

    public UserDapImpl2(){
        System.out.println("UserDapImpl正在初始化。。。");
    }

    @Override
    public String getUser(String userName) {
        return "我是: " + userName;
    }
}
