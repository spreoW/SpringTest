package com.jdbcTemplate;

import com.dao.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author wangquan
 * @date 2020/12/23
 */
public class JDBCTemplateTest2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = (IAccountDao) context.getBean("accountDao");
        System.out.println(accountDao.findAcconutById(1));
    }
}
