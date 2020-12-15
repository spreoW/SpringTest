package com.dao.impl;

import com.dao.IAccountDao;
import com.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wangquan
 * @date 2020/12/14
 */
@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            return queryRunner.query(" select * from account ", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAcconutById(Integer accountId) {
        try {
            return queryRunner.query("select * from account where id = ? ",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account(name,money) value(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            queryRunner.update("delete from account where id = ?",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
