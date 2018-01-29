package com.hehe.shoppingweb.dao;

import com.hehe.shoppingweb.entity.User;

public interface UserDao {
    public User findById(Long id);

    public void insert(User user);

    public User findByUsername(String username);
}
