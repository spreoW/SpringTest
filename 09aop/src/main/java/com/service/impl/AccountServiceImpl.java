package com.service.impl;

import com.service.IAccountService;

/**
 * @author wangquan
 * @date 2020/12/19
 */
public class AccountServiceImpl implements IAccountService {
    @Override
    public void selectAccount() {
        System.out.println("selectAccount方法开始执行。。。。。。");
    }

    @Override
    public void updateAccount(Integer id) {
        System.out.println("updateAccount方法开始执行。。。。。。");
    }

    @Override
    public void deleteAccount() {
        System.out.println("deleteAccount方法开始执行。。。。。。");
    }

    // 不需要增强的方法
    @Override
    public void otherMethod(){
        System.out.println("otherMethod方法开始执行(不需要增强)。。。。。。");
    }
}
