package com.hehe.proxy.dynamic.cglib.factory;

import com.hehe.proxy.dynamic.cglib.DoSth;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor{
    private DoSth target;
    public CglibProxyFactory(){
        target = new DoSth();
    }

    //创建创建代理对象的方法
    public DoSth Mycreate(){
        //创建增强器
        Enhancer enhancer = new Enhancer();
        //设置目标类
        enhancer.setSuperclass(target.getClass());
        //设置回调
        enhancer.setCallback(this);
        //返回代理对象
        return (DoSth)enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object o = method.invoke(target,args);
        return String.valueOf(o).toUpperCase();
    }
}
