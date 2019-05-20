package com.dollarkiller.sapectJ.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-20
 * Time: 上午10:57
 * Description: 切面类
 */
@Aspect
public class MyAspectAnno {

// 定义切点
    @Pointcut(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.save(..)))")
    private void save() {}
//    前置通知
    @Before(value = "save()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知" + joinPoint);
    }

//    后置通知
    @AfterReturning(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.update(..))",returning = "result")
    public void afterReturing(Object result) {
        System.out.println("后置通知" + result);
    }

    @Around(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.delete(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知");
        Object proceed = joinPoint.proceed();//执行目标方法
        // 如果不调用 目标方法就不会执行
        System.out.println("环绕后通知");
        return proceed;
    }

    @AfterThrowing(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.findOne(..))",throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println(e.getMessage());
    }

    @After(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.findAll(..))")
    public void after() {
        System.out.println("无论发生异常总会执行");
    }


}
