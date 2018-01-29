package com.hehe.proxy.statics.impl.test;

import com.hehe.proxy.statics.SaySomething;
import com.hehe.proxy.statics.impl.SaySomethingImpl;
import com.hehe.proxy.statics.impl.SaySomethingProxy;

public class TestStaticProxy {
    public static void main(String[] args) {
        SaySomething saySomething = new SaySomethingProxy();
        String result = saySomething.say();
        System.out.println(result);
        saySomething.play();
    }
}
