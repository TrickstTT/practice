package com.hehe.proxy.test;

import com.hehe.proxy.staticProxy.DoSth;
import com.hehe.proxy.staticProxy.Proxy.DoSthProxy;

public class test {
    public static void main(String[] args) {
        DoSth doSth = new DoSthProxy();
        String result = doSth.print();
        System.out.println(result);
    }
}
