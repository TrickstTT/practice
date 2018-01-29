package com.hehe.service;

import com.hehe.bean.User;
import com.hehe.service.impl.UserDaoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface UserDaoService {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoServiceImpl.class);

    public User isUser(String userName, String password);

    public void pay(double totalPrice, User user1, String s);
}
