AspectJAOP
===
AspectJ是局域Java语言的AOP框架
### 注解开发
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop" xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">
    <!--开启AspectJ注解开发,自动代理-->
    <aop:aspectj-autoproxy/>
    
</beans>
```

```
<dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>4.2.4.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.2.4.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>4.2.4.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-expression</artifactId>
      <version>4.2.4.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>aopalliance</groupId>
      <artifactId>aopalliance</artifactId>
      <version>1.0</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>4.2.4.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjweaver</artifactId>
      <version>RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>4.2.4.RELEASE</version>
    </dependency>
  </dependencies>
```

####  @AspectJ提供不同的通知类型
  - @Before 前置通知,相当于BeforeAdvice
  - @AfterReturning 后置通知,相当于AfterReturningAdvice
  - @Around 环绕通知 相当于MethodInterceptor
  - @AfertThrowing 异常抛出通知,相当于ThrowAdvice
  - @After最终final通知,不管是否异常都会执行
  - @DeclareParents引介通知
#### 切入点表达式的定义
- 通过excution函数,可以定义切点的方法切入
- 语法:
  - execution(<访问修饰符>?<返回类型><方法名>(<参数>)<异常>)
- 例如:
  - 匹配所有类的public方法 execution(public **(..))
  - 匹配指定包下所有类方法 execution(* com.imooc.dao.*(..)) 不包含子包
  - execution(* com.imooc.dao..*(..)) ..*标示包,子孙包下所有类
  - 匹配指定类所有方法 execution(* com.imooc.service.UserService.*(..))
  - 匹配实现特定接口所有类方法 execution(* com.imooc.dao.GenericDao+.*(..))
  - 匹配所有save开头的方法 execution(* save*(..))
```
@Aspect
public class MyAspectAnno {

    @Before(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.save(..))")
    public void before() {
        System.out.println("this is before msg");
    }
}


<!--开启AspectJ注解开发,自动代理-->
<aop:aspectj-autoproxy/>

<!--目标类-->
<bean id="productDao" class="com.dollarkiller.sapectJ.demo1.ProductDao" />

<!--定义切面-->
<bean class="com.dollarkiller.sapectJ.demo1.MyAspectAnno"/>



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo1Test {

  @Resource(name="productDao")
  private ProductDao productDao;

  @Test
  public void demo1() {
      productDao.delete();
      productDao.save();
      productDao.update();
      productDao.findAll();
      productDao.findOne();
  }
}

备注: before(JoinPoint joinPoint) 来获取切点信息

```

- 前置通知
  ```
  //    前置通知
    @Before(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.save(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知" + joinPoint);
    }
  ```
- 后置通知
  ```
  //    后置通知
    @AfterReturning(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.update(..))",returning = "result")
    public void afterReturing(Object result) {
        System.out.println("后置通知" + result);
    }
  ```
- 环绕通知
  - around方法的返回值就是目标代理方法执行返回值
  - 参数为ProceedingJoinPoint可以调用拦截目标方法执行
  ```
    @Around(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.delete(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知");
        Object proceed = joinPoint.proceed();//执行目标方法
        // 如果不调用 目标方法就不会执行
        System.out.println("环绕后通知");
        return proceed;
    }
  ```
- 异常抛出通知
  - 通过设置throwing属性,可以设置发送异常对象参数
  ```
      @AfterThrowing(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.findOne(..))",throwing = "e")
      public void afterThrowing(Throwable e) {
          System.out.println(e.getMessage());
      }
  ```
- 最终通知  (无论出现异常总会执行)
    ```
    @After(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.findAll(..))")
    public void after() {
        System.out.println("无论发生异常总会执行");
    }
    ```
- 切点命名
  - 切点方法:private void 无参数方法,名称为切点名称
  - 当通知多个切点时,可以使用||进行链接
    ```
    // 定义切点
        @Pointcut(value = "execution(* com.dollarkiller.sapectJ.demo1.ProductDao.save(..)))")
        private void save() {}
    //    前置通知
        @Before(value = "save()")
        public void before(JoinPoint joinPoint) {
            System.out.println("前置通知" + joinPoint);
        }
    ```
- xml方式
    ```
        <!--XML配置方式完成AOP开发-->

    <!--配置目标类-->
    <bean id="customerDao" class="com.dollarkiller.sapectJ.demo2.CustomerDaoImpl" />

    <!--配置切面类-->
    <bean id="myAspectXml" class="com.dollarkiller.sapectJ.demo2.MyAspectXml"/>

    <!--aop相关配置-->
    <aop:config>
        <!--配置切入点-->
        <aop:pointcut id="pointcu1" expression="execution(* com.dollarkiller.sapectJ.demo2.CustomerDaoImpl.save(..))"/>
        
        <!--配置AOP切面-->
        <aop:aspect ref="myAspectXml">
            <!--配置前置通知-->
            <aop:before method="before" pointcut-ref="pointcu1"/>
        </aop:aspect>
    </aop:config>
    ```