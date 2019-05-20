package com.dollarkiller.demo2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-2
 * Time: 上午9:46
 * Description: No Description
 */
public class MyCglibProxy implements MethodInterceptor {
    private ProductDao productDao;
    public MyCglibProxy(ProductDao productDao) {
        this.productDao = productDao;
    }
    public Object createProxy() {
        //1 创建核心类
        Enhancer enhancer = new Enhancer();
        //2 设置父类
        enhancer.setSuperclass(productDao.getClass());
        //3 设置回调
        enhancer.setCallback(this);
        //4 生成代理
        Object proxy = enhancer.create();
        return proxy;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("save".equals(method.getName())) {
            System.out.println("权限校验");
            return methodProxy.invokeSuper(o,objects);
        }
        return methodProxy.invokeSuper(o,objects);
    }
}
