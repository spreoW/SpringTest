package com.utils;

import java.sql.SQLException;

/**
 * @author w
 * @date 2020/12/14
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
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
            // 连接还回连接池
            connectionUtils.getThreadConnection().close();
            // 解绑
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
