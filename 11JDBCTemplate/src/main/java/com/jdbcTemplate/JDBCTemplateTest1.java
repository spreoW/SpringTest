package com.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author wangquan
 * @date 2020/12/23
 */
public class JDBCTemplateTest1 {
    public static void main(String[] args) {

        // 创建JDBCTemplate对象
        JdbcTemplate jt  = new JdbcTemplate();
        // 设置DataSource数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        jt.setDataSource(dataSource);
        //执行SQL
        jt.execute("INSERT INTO ACCOUNT(name,money) VALUE ('dd',1000)");
    }
}
