package com.hehe.view;

import com.hehe.bean.User;
import com.hehe.service.UserDaoService;
import com.hehe.service.impl.UserDaoServiceImpl;

import java.util.Scanner;

public class Login {
    public final User login(){
        while(true){
            UserDaoService userDaoService = new UserDaoServiceImpl();
            System.out.println("请输入帐号密码，空格隔开");
            Scanner sc = new Scanner(System.in);
            String [] arr = sc.nextLine().split(" ");
            if(arr.length!=2){
                System.out.println("输入格式错误，请重新输入");
                continue;
            }
            String userName = arr[0];
            String password = arr[1];
            //核对是否存在用户名
            User user = userDaoService.isUser(userName,password);
            if(user != null){
                System.out.println("登录成功");
                System.out.println(user.toString());
                return user;
            }else{
                System.out.println("帐号密码错误，请重新登录");
            }
        }
    }

}
