package com.service;

import com.domain.Account;

import java.util.List;

/**
 * @author wangquan
 * @date 2020/12/14
 */
public interface IAccountService {
    public List<Account> findAllAccount();

    public Account findAcconutById(Integer accountId);

    public void saveAccount(Account account);

    public void updateAccount(Account account);

    public void deleteAccount(Integer accountId);
}
