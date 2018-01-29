package com.hehe.proxy.jdk.test;

import com.hehe.proxy.jdk.DoSth;
import com.hehe.proxy.jdk.Impl.DoSthImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        DoSth target = new DoSthImpl();
        DoSth doSth = (DoSth) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object obj = method.invoke(new DoSthImpl(), args);
                        System.out.println("zzzzzzz");
                        return String.valueOf(obj).toUpperCase();
                    }
                }
        );
        String str = doSth.print();
        System.out.println(str);
    }
}
