package com.hehe.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibFactory implements MethodInterceptor{
    private DoSth target;
    public CglibFactory(){
        target = new DoSth();
    }

    public DoSth getDoSthProxy(){
        //获得增强器
        Enhancer enhancer = new Enhancer();
        //设置目标类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        return ((DoSth) enhancer.create());
    }
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = method.invoke(target, args);
        return String.valueOf(result).toUpperCase();
    }
}
