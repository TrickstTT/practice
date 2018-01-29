package com.hehe.dao;

import com.hehe.bean.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();
    public void updateMoney(String payWay, double money);
}
