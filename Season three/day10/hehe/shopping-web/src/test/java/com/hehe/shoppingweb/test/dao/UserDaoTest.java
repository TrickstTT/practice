package com.hehe.shoppingweb.test.dao;

import com.hehe.shoppingweb.dao.UserDao;
import com.hehe.shoppingweb.entity.User;
import com.hehe.shoppingweb.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
    private SqlSession sqlSession = null;
    private UserDao userDao = null;

    @Before
    public void before(){
        sqlSession = MybatisUtil.getSqlSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @Test
    public void testFindByUsername(){
        User user = userDao.findByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        User user = new User("hehe","123","hehe",18,"13131313131","45454545@qq.com");
        System.out.println(user);
        userDao.insert(user);
        sqlSession.commit();
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
