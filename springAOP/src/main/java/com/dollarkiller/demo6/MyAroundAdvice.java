package com.dollarkiller.demo6;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-2
 * Time: 下午3:10
 * Description: No Description
 */
public class MyAroundAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕前pp");
        Object obj = methodInvocation.proceed();
        System.out.println("环绕后pp");
        return obj;
    }
}
