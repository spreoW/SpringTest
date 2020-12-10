package com.dao.impl;

import com.dao.UserDao;

/**
 * @author wangquan
 * @date 2020/12/10
 */
public class UserDapImpl implements UserDao {
    @Override
    public String getUser(String userName) {

        return "我是: " + userName;
    }
}
