package com.hehe.shopping.service;

import com.hehe.shopping.entity.User;

public interface UserDaoService {

   public User checkUser(String username, String password);
}
