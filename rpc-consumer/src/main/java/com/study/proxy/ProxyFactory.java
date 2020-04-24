package com.study.proxy;

import com.study.api.UserService;
import com.study.invo.MyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * 动态代理类
 */
public class ProxyFactory {

    public  static UserService  getUserService(Class  clazz){
        return null ;
    }

    /**
     * 动态代理
     * @param clazz
     * @param <T>
     * @return
     */
    public  static <T>T  getServiceByClass(Class<T>  clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new MyInvocationHandler());
    }
}
