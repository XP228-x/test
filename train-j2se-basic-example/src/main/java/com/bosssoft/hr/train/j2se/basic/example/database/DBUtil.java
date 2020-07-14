package com.bosssoft.hr.train.j2se.basic.example.database;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * @description:  我是工具类并且我不喜欢被继承 final 保护了我免于继承，private 保护我被创建
 * @author: Administrator
 * @create: 2020-05-28 20:45
 * @since
 **/
@Slf4j
public final class DBUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/t_user?serverTimezone=UTC";
    public static final String NAME = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet;

    static {
        try {
            Class.forName(NAME);
        } catch (ClassNotFoundException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    private DBUtil() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * 释放资源
     */
    public static void closeResource() {
        closeResultSet();
        closeStatement();
        closeConnection();
    }

    /**
     * 释放连接 Connection
     */
    public static void closeConnection() {
        if(connection !=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error(e.getLocalizedMessage(), e);
            }
        }
        //等待垃圾回收
        connection = null;
    }

    /**
     * 释放语句执行者 Statement
     */
    public static void closeStatement() {
        if(statement !=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                log.error(e.getLocalizedMessage(), e);
            }
        }
        //等待垃圾回收
        statement = null;
    }

    /**
     * 释放结果集 ResultSet
     */
    public static void closeResultSet() {
        if(resultSet !=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                log.error(e.getLocalizedMessage(), e);
            }
        }
        //等待垃圾回收
        resultSet = null;
    }

    public static int executeUpdate(String sql) throws SQLException {
        connection = getConnection();
        statement = connection.prepareStatement(sql);
        int result = statement.executeUpdate();

        closeResource();

        return result;
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        connection = getConnection();
        statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();

        return resultSet;
    }



}
