package com.hehe.shopping.view;

import com.hehe.shopping.entity.User;
import com.hehe.shopping.service.UserDaoService;
import com.hehe.shopping.service.impl.UserDaoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Login {
    private static final Logger LOGGER = LoggerFactory.getLogger(Login.class);

    private Scanner sc = null;
    public Login(){
        sc = new Scanner(System.in);
    }
    public User login(){
        System.out.print("请输入帐号：");
        String username = sc.next();
        System.out.print("请输入密码：");
        String password = sc.next();
        User user = checkLogin(username,password);
        return user;
    }

    private User checkLogin(String username, String password) {
        UserDaoService userDaoService = new UserDaoServiceImpl();
        User user = userDaoService.checkUser(username,password);
        if(user == null){
            loginFail(username);
        }
        else{
            loginSuccess(username);
        }
        return user;
    }

    private void loginSuccess(String username) {
        LOGGER.info("用户\"{}\"登录成功",username);
    }

    private void loginFail(String username) {
        LOGGER.warn("用户\"{}\"登录失败",username);
        login();
    }
}
