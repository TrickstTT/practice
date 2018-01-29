package com.hehe.service.impl;

import com.hehe.bean.User;
import com.hehe.dao.UserDao;
import com.hehe.dao.impl.UserDaoImpl;
import com.hehe.service.UserDaoService;

import java.util.List;

public class UserDaoServiceImpl implements UserDaoService {

    public User isUser(String userName,String password){
        UserDao userDao = new UserDaoImpl();
        List<User> users = userDao.getAllUser();
        if(userName==null || password == null){
            return null;
        }
        for (User user : users) {
            if(userName.equals(user.getUserName()) && password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public void pay(double actualPrice, User user, String flag) {
        UserDao userDao = new UserDaoImpl();
        String payWay = user.getUserName()+"Money"+flag;
        double money = 0.0;
        //修改user的money信息
        if("1".equals(flag)){
            money = user.getMoneyOne()-actualPrice;
            user.setMoneyOne(money);
        }else{
            money = user.getMoneyTwo()-actualPrice;
            user.setMoneyTwo(money);
        }
        //修改配置文件的money信息
        userDao.updateMoney(payWay,money);
        LOGGER.info("消费信息：{}消费了{}元",user.getUserName(),actualPrice);
    }
}
