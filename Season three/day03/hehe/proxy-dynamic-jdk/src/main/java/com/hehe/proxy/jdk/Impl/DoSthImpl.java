package com.hehe.proxy.jdk.Impl;

import com.hehe.proxy.jdk.DoSth;

public class DoSthImpl implements DoSth{
    public String print() {
        System.out.println("执行print方法");
        return "hehe";
    }
}
