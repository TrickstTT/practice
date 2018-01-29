package com.hehe.proxy.dynamic.jdk.impl;

import com.hehe.proxy.dynamic.jdk.DoSth;

public class DoSthImpl implements DoSth{
    public String say() {
        System.out.println("say:somebody that I used to know");
        return "hehe";
    }

    public void play() {
        System.out.println("play:song of winds");
    }
}
