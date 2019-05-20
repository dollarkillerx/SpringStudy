package com.dollarkiller.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-2
 * Time: 上午9:30
 * Description: No Description
 */
public class MyJdkProxy implements InvocationHandler {
    private UserDao userDao;
    public MyJdkProxy(UserDao userDao) {
        this.userDao = userDao;
    }


    public Object createProxy() {
        Object proxy = Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),this);
        return proxy;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("save".equals(method.getName())) {
            System.out.println("权限校验");
            return method.invoke(userDao,args);
        }
        return method.invoke(userDao,args);
    }
}
