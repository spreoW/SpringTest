package com.service.impl;

import com.dao.IAccountDao;
import com.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangquan
 * @date 2020/12/10
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao userDapImpl;

    @Override
    public String getUser(String name) {
        return userDapImpl.getUser(name);
    }
}
