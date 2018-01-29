package com.hehe.test;

import com.hehe.bean.User;
import com.hehe.dao.UserDao;
import com.hehe.dao.impl.UserDaoImpl;
import com.hehe.view.Login;
import com.hehe.view.ShoppingPattern;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class UserDaoTest {
    @Test
    public void test(){
        UserDao userDao = new UserDaoImpl();
        List<User> allUser = userDao.getAllUser();
        for (User user : allUser) {
            System.out.println("h=============");
            System.out.println(user.toString());
            System.out.println(user.getPassword());
        }
        assertNotEquals(allUser.get(0), allUser.get(1));
    }

}
