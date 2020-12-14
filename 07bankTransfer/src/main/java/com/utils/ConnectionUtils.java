package com.utils;

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
     * ��ȡ��ǰ�̵߳�����
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
