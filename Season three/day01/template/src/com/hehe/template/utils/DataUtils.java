package com.hehe.template.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataUtils {
    private static String driver;
    private static String url;
    private static String userName;
    private static String password;

    static {
        InputStream inputStream = DataUtils.class.getClassLoader().getResourceAsStream("database.properties");
        Properties prop = new Properties();
        try {
            //通过配置文件获取信息
            prop.load(inputStream);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            userName = prop.getProperty("userName");
            password = prop.getProperty("password");
            //注册driverManager
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql:localhost:3306/season02_test", "root", "root");
        return connection;
    }

    public static void release(Connection connection, ResultSet resultSet, Statement statement) {

        try {
            if (connection != null) {
                connection.close();
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int update(String sql, Object... objects) throws Exception {
        Connection connection = getConnection();
        PreparedStatement pStatement = connection.prepareStatement(sql);
        for(int i=0;i<objects.length;i++){
            pStatement.setObject(i+1,objects[i]);
        }
        int result = pStatement.executeUpdate();
        return result;
    }
}
