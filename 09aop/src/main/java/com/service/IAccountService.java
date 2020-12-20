package com.service;

import java.io.Serializable;

/**
 * @author wangquan
 * @date 2020/12/19
 */
public interface IAccountService extends Serializable {
    void selectAccount();

    void updateAccount(Integer id);

    void deleteAccount();

    void otherMethod();
}
