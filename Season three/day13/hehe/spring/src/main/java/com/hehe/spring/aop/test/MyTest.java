package com.hehe.spring.aop.test;

import com.hehe.spring.aop.service.SomeService;
import com.hehe.spring.aop.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        SomeService someService1 = (SomeService) context.getBean("someService");
        SomeService someService2 = (SomeService) context.getBean("someService");
        someService1.doSth();
        System.out.println(someService1 == someService2);
        StudentService studentService = (StudentService) context.getBean("student");
        studentService.doSth();
    }
}
