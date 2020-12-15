package com.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author w
 * @date 2020/12/14
 */
public class ConnectionUtils {
    private Connection connection = null;
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程的连接
     */
    public Connection getThreadConnection() {
        try {
            connection = connectionThreadLocal.get();
            if(connection == null){
                connection = dataSource.getConnection();
                connectionThreadLocal.set(connection);
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeConnection(){
        connectionThreadLocal.remove();
    }
}
