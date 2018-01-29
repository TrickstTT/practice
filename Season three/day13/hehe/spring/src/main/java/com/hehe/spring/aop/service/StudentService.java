package com.hehe.spring.aop.service;

import org.springframework.stereotype.Component;

@Component(value = "student")
public class StudentService {
    public void doSth(){
        System.out.println("student:dosth");
    }
}
