package com.hehe.shopping.dao.test;

import com.hehe.shopping.dao.Impl.UserDaoImpl;
import com.hehe.shopping.dao.UserDao;
import com.hehe.shopping.entity.User;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
    private UserDao userDao = null;
    @Before
    public void befro(){
        userDao = new UserDaoImpl();
    }
    @Test
    public void test(){
        User user = new User();
        user.setUsername("hehe");
        user.setPassword("123");
        User result = userDao.selectUserByUsernameAndPassword(user);
        System.out.println(result.getId());

    }
}
