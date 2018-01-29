package com.kf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kf.bean.Img;
import com.kf.utils.DataUtil;

public class DaoImg {
	//增加用户
		public int insert(Img img) {
			String sql = "insert into img(userName,touXiangImg,idFontImg,idBackImg,biYeZhengImg) values(?,?,?,?,?);";
			return DataUtil.update(sql,img.getUserName(),img.getTouXiangImg(),img.getIdFontImg(),img.getIdBackImg(),img.getBiYeZhengImg());
		}
		
		//删除用户
		public int delete(String userName){
			String sql = "delete from img where userName="+userName;
			return DataUtil.update(sql,userName);
		}
		//修改用户信息
		public int update(String userName,Img img){
			String sql = "update img set userName=?,touXiangImg=?,idFontImg=?,idBackImg=?,biYeZhengImg=? where userName = ?";
			return DataUtil.update(sql, img.getUserName(),img.getTouXiangImg(),
					img.getIdFontImg(),img.getIdBackImg(),img.getBiYeZhengImg(),userName);
		}
		//查找一个用户
		public Img findOne(String userName){
			Connection connection =null;
			PreparedStatement pStatement = null;
			ResultSet resultSet = null;
			try {
				connection = DataUtil.getConnection();
				pStatement = connection.prepareStatement("select * from img where userName =?");
				pStatement.setString(1, userName);
				resultSet = pStatement.executeQuery();
				if(resultSet.next()){
					String touXiangImg = resultSet.getString("touXiangImg");
					String idFontImg = resultSet.getString("idFontImg");
					String idBackImg = resultSet.getString("idBackImg");
					String biYeZhengImg = resultSet.getString("biYeZhengImg");
					return new Img(userName, touXiangImg, idFontImg, idBackImg, biYeZhengImg);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DataUtil.release(resultSet, pStatement, connection);
			}
			return null;
		}
		//查找全部
		public List<Img> findAll(){
			Connection connection =null;
			PreparedStatement pStatement = null;
			ResultSet resultSet = null;
			try {
				connection = DataUtil.getConnection();
				pStatement = connection.prepareStatement("select * from img ");
				resultSet = pStatement.executeQuery();
				List<Img> list = new ArrayList<>();
				while(resultSet.next()){
					String userName = resultSet.getString("userName");
					String touXiangImg = resultSet.getString("touXiangImg");
					String idFontImg = resultSet.getString("idFontImg");
					String idBackImg = resultSet.getString("idBackImg");
					String biYeZhengImg = resultSet.getString("biYeZhengImg");
					list.add(new Img(userName, touXiangImg, idFontImg, idBackImg, biYeZhengImg));
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
