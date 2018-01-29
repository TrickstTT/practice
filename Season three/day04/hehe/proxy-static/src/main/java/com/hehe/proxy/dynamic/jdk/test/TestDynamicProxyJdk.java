package com.hehe.proxy.dynamic.jdk.test;

import com.hehe.proxy.dynamic.jdk.DoSth;
import com.hehe.proxy.dynamic.jdk.impl.DoSthImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxyJdk {
    public static void main(String[] args) {
        DoSth target = new DoSthImpl();
        DoSth doSthProxy = (DoSth) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = method.invoke(new DoSthImpl(), args);
                        result = String.valueOf(result).toUpperCase();
                        return result;
                    }
                }
        );
        doSthProxy.play();
        String result = doSthProxy.say();
        System.out.println(result);
    }
}
