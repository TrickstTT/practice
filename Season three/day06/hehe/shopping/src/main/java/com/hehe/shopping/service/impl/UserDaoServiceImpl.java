package com.hehe.shopping.service.impl;

import com.hehe.shopping.dao.Impl.UserDaoImpl;
import com.hehe.shopping.dao.UserDao;
import com.hehe.shopping.entity.User;
import com.hehe.shopping.service.UserDaoService;

public class UserDaoServiceImpl implements UserDaoService {
    @Override
    public User checkUser(String username, String password) {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User result = userDao.selectUserByUsernameAndPassword(user);
        return result;
    }
}
