package com.hehe.proxy.dynamic.cglib;

public class TestDynamidProxyCglib {
    public static void main(String[] args) {
        CglibFactory cglibFactory = new CglibFactory();
        DoSth doSth = cglibFactory.getDoSthProxy();
        doSth.play();
        String result = doSth.say();
        System.out.println(result);
    }
}
