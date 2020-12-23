package com.dao.impl;

import com.dao.IAccountDao;
import com.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangquan
 * @date 2020/12/14
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Account> findAllAccount() {
        return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account findAcconutById(Integer accountId) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ? ", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accounts.get(0);
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ? , money = ? where id  = ? ",account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public void deleteAccount(Integer accountId) {
    }
}
