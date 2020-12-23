package test;

import com.domain.Account;
import com.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
