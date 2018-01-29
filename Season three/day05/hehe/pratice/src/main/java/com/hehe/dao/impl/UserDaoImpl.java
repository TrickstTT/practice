package com.hehe.dao.impl;

import com.hehe.bean.User;
import com.hehe.dao.UserDao;
import com.hehe.proxy.CglibFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    //获取所有用户
    public List<User> getAllUser(){
        List<User> users = new ArrayList<User>();
        Properties properties = new Properties();
        double vipMoney1;
        double vipMoney2;
        double heheMoney1;
        double heheMoney2;
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.properties");
            properties.load(in);
            vipMoney1 = Double.parseDouble(properties.getProperty("vipMoney1"));
            vipMoney2 = Double.parseDouble(properties.getProperty("vipMoney2"));
            heheMoney1 = Double.parseDouble(properties.getProperty("heheMoney1"));
            heheMoney2 = Double.parseDouble(properties.getProperty("heheMoney2"));
            User user1 = new CglibFactory().createUser();
            User user2 = new CglibFactory().createUser();
            user1.setUserName("vip");
            user1.setPassword("123");
            user1.setMoneyOne(vipMoney1);
            user1.setMoneyTwo(vipMoney2);
            user2.setUserName("hehe");
            user2.setPassword("123");
            user2.setMoneyOne(heheMoney1);
            user2.setMoneyTwo(heheMoney2);
            users.add(user2);
            users.add(user1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateMoney(String payWay, double money) {
        Properties properties = new Properties();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.properties");
        try {
            OutputStream out = new FileOutputStream("D:\\Java资料\\My\\day05\\hehe\\pratice\\src\\main\\resources\\user.properties");
            properties.load(in);
            properties.setProperty(payWay,String.valueOf(String.valueOf(money)));
            properties.store(out,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
