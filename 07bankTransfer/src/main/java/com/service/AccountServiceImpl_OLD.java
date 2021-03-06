package com.service;

import com.dao.IAccountDao;
import com.domain.Account;
import com.utils.ConnectionUtils;
import com.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangquan
 * @date 2020/12/14
 */
@Service("accountService_OLD")
public class AccountServiceImpl_OLD implements IAccountService {

    @Autowired
    TransactionManager transactionManager;

    @Autowired
    IAccountDao accountDao;

    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAcconutById(Integer accountId) {
        return accountDao.findAcconutById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        try {
            transactionManager.beginTransaction();
            accountDao.updateAccount(account);
            int a = 1/0;
            transactionManager.commitTransaction();
        }catch (Exception e){
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        }finally {
            transactionManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
