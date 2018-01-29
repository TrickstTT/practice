package com.kf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kf.bean.User;
import com.kf.utils.DataUtil;

public class DaoUser {
	//增加用户
	public int insert(User user) {
		String sql = "insert into user(userName,name,gender,password,idCard,phone,qq,"+
	"number,school,studyStatus,background,class,applyDate,addr) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		return DataUtil.update(sql, user.getUserName(),user.getName(),user.getGender(),user.getPassword(),user.getIdCard(),user.getPhone(),
				user.getQq(),user.getNumber(),user.getSchool(),user.getStudyStatus(),user.getBackground(),
				user.getClassName(),user.getApplyDate(),user.getAddr());
	}
	
	//删除用户
	public int delete(String userName){
		String sql = "delete from user where userName="+userName;
		return DataUtil.update(sql,userName);
	}
	//修改用户信息
	public int update(String userName,User user){
		String sql = "update user set name=?,gender=?,password=?,idCard=?,phone=?,qq=?,"+
	"number=?,school=?,studyStatus=?,background=?,class=?,applyDate=?,addr=? where userName = ?";
		return DataUtil.update(sql, user.getName(),user.getGender(),user.getPassword(),user.getIdCard(),user.getPhone(),
				user.getQq(),user.getNumber(),user.getSchool(),user.getStudyStatus(),user.getBackground(),
				user.getClassName(),user.getApplyDate(),user.getAddr(),userName);
	}
	//查找一个用户
	public User findOnd(String userName){
		Connection connection =null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DataUtil.getConnection();
			pStatement = connection.prepareStatement("select * from user where userName =?");
			pStatement.setString(1, userName);
			resultSet = pStatement.executeQuery();
			if(resultSet.next()){
				String name = resultSet.getString("name");
				String gender = resultSet.getString("gender");
				String password = resultSet.getString("password");
				String idCard = resultSet.getString("idCard");
				String phone = resultSet.getString("phone");
				String qq = resultSet.getString("qq");
				String number = resultSet.getString("number");
				String school = resultSet.getString("school");
				String studyStatus = resultSet.getString("studyStatus");
				String background = resultSet.getString("background");
				String className = resultSet.getString("class");
				String applyDate = resultSet.getString("applyDate");
				String addr = resultSet.getString("addr");
				return new User(userName,name,gender, password, idCard, phone, qq, number, school, studyStatus, background, className, applyDate, addr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataUtil.release(resultSet, pStatement, connection);
		}
		return null;
	}
	//查找全部
	public List<User> findAll(){
		Connection connection =null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DataUtil.getConnection();
			pStatement = connection.prepareStatement("select * from user ");
			resultSet = pStatement.executeQuery();
			List<User> list = new ArrayList<>();
			while(resultSet.next()){
				String userName = resultSet.getString("userName");
				String name = resultSet.getString("name");
				String gender = resultSet.getString("gender");
				String password = resultSet.getString("password");
				String idCard = resultSet.getString("idCard");
				String phone = resultSet.getString("phone");
				String qq = resultSet.getString("qq");
				String number = resultSet.getString("number");
				String school = resultSet.getString("school");
				String studyStatus = resultSet.getString("studyStatus");
				String background = resultSet.getString("background");
				String className = resultSet.getString("class");
				String applyDate = resultSet.getString("applyDate");
				String addr = resultSet.getString("addr");
				list.add(new User(userName,name,gender, password, idCard, phone, qq, number, school, studyStatus, background, className, applyDate, addr));
			}	
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataUtil.release(resultSet, pStatement, connection);
		}
		return null;
	}
}
