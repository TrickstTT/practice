package com.hehe.proxy.statics.impl;

import com.hehe.proxy.statics.SaySomething;

public class SaySomethingImpl implements SaySomething{
    public String say() {
        System.out.println("say:somebody that i used to know");
        return "hehe";
    }
    public void play(){
        System.out.println("play:song of wind");
    }
}
