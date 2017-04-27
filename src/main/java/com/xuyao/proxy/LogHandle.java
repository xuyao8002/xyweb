package com.xuyao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by xuyao on 2017/4/19.
 */
public class LogHandle implements InvocationHandler {

    private Object object;

    public LogHandle(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Class name: " + object.getClass().getName());
        Object obj = method.invoke(object, args);
        System.out.println("Method name: " + method.getName() + ", args: " + args);
        return null;
    }
}
