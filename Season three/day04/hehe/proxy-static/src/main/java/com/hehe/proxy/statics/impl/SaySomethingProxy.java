package com.hehe.proxy.statics.impl;

import com.hehe.proxy.statics.SaySomething;

public class SaySomethingProxy implements SaySomething{
    private SaySomething saySomething;
    public SaySomethingProxy(){
        saySomething = new SaySomethingImpl();
    }

    public String say() {
        String result = saySomething.say();
        return result.toUpperCase();
    }

    public void play() {
        saySomething.play();
    }
}
