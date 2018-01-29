package com.hehe.shopping.dao;

import com.hehe.shopping.entity.User;

public interface UserDao {
    public User selectUserByUsernameAndPassword(User user);
}
