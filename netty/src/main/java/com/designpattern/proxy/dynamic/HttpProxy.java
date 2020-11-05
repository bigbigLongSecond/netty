package com.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dzl
 * 2020/10/26 10:03
 * @Description
 */
public class HttpProxy implements InvocationHandler {
    private HttpUtil iHttp;
    public IHttp getInstance(HttpUtil iHttp){
        this.iHttp = iHttp;
        return (IHttp) Proxy.newProxyInstance(iHttp.getClass().getClassLoader() ,iHttp.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        if (method.getName().equals("request")) {
            System.out.println("发送数据为" + args[0]);
        } else {
            System.out.println("收到数据:" + args[0]);
        }
        object = method.invoke(iHttp, args);
        return object;
    }

}
