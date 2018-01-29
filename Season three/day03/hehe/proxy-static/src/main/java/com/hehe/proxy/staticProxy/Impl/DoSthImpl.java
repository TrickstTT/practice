package com.hehe.proxy.staticProxy.Impl;

import com.hehe.proxy.staticProxy.DoSth;

public class DoSthImpl implements DoSth{
    public String print() {
        System.out.println("执行print方法");
        return "hehe";
    }
}
