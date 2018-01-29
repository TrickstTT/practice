package com.hehe.test.service;

import com.hehe.service.UserService;
import com.hehe.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Target;

public class UserServiceTest {
    public static void main(String[] args) {
//        normalInvoke();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService1 = (UserService) applicationContext.getBean("userService");
        UserService userService2 = (UserService) applicationContext.getBean("userService");
        System.out.println(userService1+"\r\n"+userService2);
    }

    private static void normalInvoke() {
        UserService userService = new UserServiceImpl();
        userService.print("normal invoke");
    }
}
