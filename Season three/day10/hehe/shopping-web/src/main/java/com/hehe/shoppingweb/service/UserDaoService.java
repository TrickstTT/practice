package com.hehe.shoppingweb.service;

import com.hehe.shoppingweb.entity.User;

public interface UserDaoService {
    public User isUser(String username, String password);

    public void updateUser(String username, String password, String name, String age, String phone, String email);

    public void insertUser(String username, String password, String phone);
}
