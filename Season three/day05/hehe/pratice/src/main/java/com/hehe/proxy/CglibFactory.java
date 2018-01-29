package com.hehe.proxy;

import com.hehe.bean.User;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibFactory implements MethodInterceptor{
    private User target;
    public CglibFactory(){
        target = new User();
    }
    public User createUser(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return ((User) enhancer.create());
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = method.invoke(target,args);

        Method method1 = target.getClass().getMethod("setMoneyOne", double.class);
        Method method2 = target.getClass().getMethod("setMoneyTwo", double.class);
        Method method3 = target.getClass().getDeclaredMethod("setMoneyOne", double.class);
        Method method4 = target.getClass().getDeclaredMethod("setMoneyTwo", double.class);
        if(method.equals(method1) || method.equals(method2) || method.equals(method3) || method.equals(method4)){
            System.out.println("用户余额有变化!!!");
            String str = (String) target.getClass().getMethod("toString").invoke(target);
            System.out.println("当前用户信息为："+str);
        }
//        if(method.equals(method1)){
//
//        }else if(method.equals(method2)){
//
//        }else if(method.equals(method3)){
//
//        }else if(method.equals(method4)){
//
//        }
        return result;
    }
}
