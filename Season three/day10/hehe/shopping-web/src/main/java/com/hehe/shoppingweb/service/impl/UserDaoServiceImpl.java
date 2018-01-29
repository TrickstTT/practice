package com.hehe.shoppingweb.service.impl;

import com.hehe.shoppingweb.dao.UserDao;
import com.hehe.shoppingweb.entity.User;
import com.hehe.shoppingweb.service.UserDaoService;
import com.hehe.shoppingweb.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserDaoServiceImpl implements UserDaoService{

    public User isUser(String username, String password) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findByUsername(username);
//        sqlSession.close();
        if(user == null){
            return null;
        }
        else{
            if(user.getPassword().equals(password)){
                return user;
            }
            else{
                return null;
            }
        }
    }

    @Override
    public void insertUser(String username, String password, String phone) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.insert(user);
        sqlSession.commit();
//        sqlSession.close();
    }

    @Override
    public void updateUser(String username, String password, String name, String age, String phone, String email) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        user.setPassword(phone);
        user.setEmail(email);
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.insert(user);
//        sqlSession.close();
    }
}
