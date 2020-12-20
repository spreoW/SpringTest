package com.test;

import com.dao.IAccountDao;
import com.domain.Account;
import com.service.IAccountService;
import com.utils.ConnectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wangquan
 * @date 2020/12/14
 */
public class TestAccount {




    @Test
    public void testupdateAccount() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        Account account = new Account();
        account.setId(1);
        account.setMoney(900D);
        account.setName("aaa");
        accountService.updateAccount(account);
    }

    @Test
    public void testFindAccountAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) context.getBean("proxyAccountServiceByCglib");
        Account account = new Account();
        account.setId(1);
        account.setMoney(500D);
        account.setName("aaa");
        accountService.updateAccount(account);
        //System.out.println(accountService.findAcconutById(1));
    }
}
