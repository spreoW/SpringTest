package com.dao.impl;

import com.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author wangquan
 * @date 2020/12/10
 */
@Repository
public class AccountDaoImpl implements IAccountDao {

    @Override
    public String getUser(String userName) {
        return "我是: " + userName;
    }
}
