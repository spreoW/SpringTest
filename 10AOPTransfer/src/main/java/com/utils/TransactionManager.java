package com.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author w
 * @date 2020/12/14
 */
@Aspect
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.service.impl.*.*(..))")
    private void pointcut(){}

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    @Before("pointcut()")
    public void beginTransaction(){
        try {
            System.out.println("开启事务。。。");
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    public void commitTransaction(){
        try {
            System.out.println("提交事务。。。");
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public void rollbackTransaction(){
        try {
            System.out.println("回滚事务。。。");
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 释放资源
     */
    public void release(){
        try {
            System.out.println("释放事务。。。");
            // 连接还回连接池
            connectionUtils.getThreadConnection().close();
            // 解绑
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
