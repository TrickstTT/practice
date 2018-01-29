package com.kf.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static{
		try {
			Properties prop = new Properties();
			InputStream is = DataUtil.class.getClassLoader().getResourceAsStream("Database.properties");
			prop.load(is);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int update(String sql,Object...params){
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pStatement.setObject(i+1, params[i]);
			}
			int result = pStatement.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			release(null, pStatement, connection);
		}
		return 0;		
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	public static void release (ResultSet resultSet,PreparedStatement pStatement,Connection connection){
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (Exception e) {
			}
		}
		if(pStatement != null){
			try {
				pStatement.close();
			} catch (Exception e) {
			}
		}
		if(connection != null){
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
	}
}
