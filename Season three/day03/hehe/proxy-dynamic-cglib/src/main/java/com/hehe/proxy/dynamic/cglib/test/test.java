package com.hehe.proxy.dynamic.cglib.test;

import com.hehe.proxy.dynamic.cglib.DoSth;
import com.hehe.proxy.dynamic.cglib.factory.CglibProxyFactory;

public class test {
    public static void main(String[] args) {
        DoSth doSth = new CglibProxyFactory().Mycreate();
        String result = doSth.print();
        System.out.println(result);
    }
}
