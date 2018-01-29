package com.hehe.proxy.staticProxy.Proxy;

import com.hehe.proxy.staticProxy.DoSth;
import com.hehe.proxy.staticProxy.Impl.DoSthImpl;


public class DoSthProxy implements DoSth{
    private DoSth target;
    public DoSthProxy(){
        target = new DoSthImpl();
    }
    public String print() {
        String result = target.print();
        return result.toUpperCase();
    }
}
