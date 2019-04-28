# SpringStudy
Spring小白入门

## Spring Framework

### Spring IOC
> IOC Inverse of Control 翻转控制,就是将原来在程序中手动创建的JavaBean对象的控制器,交给Spring框架管理

### DI Dependency Injection 依赖注入
> Soring创建了类对象的过程中,将这个对象所以依赖的属性注入进去.
```
    <!--    Bean的创建权交个spring-->
    <bean id="userService" class="com.dollarkiller.ioc.demo1.UserServiceImpl"> 控制反转
        <!--        设置属性-->
        <property name="name" value="王五"/>  依赖注入
    </bean>
```

#### 工厂类
- ApplicationContext 
- 加载文件下的配置文件 FileSystemXMLApplicationContext
- 加载class下的配置文件 ClassPathXMLApplicationContext 
#### Spring Bean管理——XML方式
- 使用类构造器实例化(默认无参数)
- 使用静态工厂方法实例化(简单工厂模式)
- 使用实例工厂方法实例化(工厂方法模式)
```
    <!--Bean的实例化的三种方式-->
    <!-- 第一种:无参构造方法 -->
    <bean id="bean1" class="com.dollarkiller.ioc.demo2.Bean1"></bean>
    <!-- 第二种:静态工厂方式 -->
    <bean id="bean2" class="com.dollarkiller.ioc.demo2.Bean2Factory" factory-method="createBean2"/>
    <!--第三种:实例工厂方法-->
    <bean id="bean3Factory" class="com.dollarkiller.ioc.demo2.Bean3Factory" ></bean>
    <bean id="bean3" factory-bean="bean3Factory" factory-method="createBean3"></bean>
```
#### Bean的常用配置
- id和name
  - 一般情况下,装配一个Bean时,通过指定一个id属性最为Bean的名称
  - id属性在IOC容器中必须是唯一的
  - 如果Bean的名称中含有特殊字符,就需要使用name属性
- class
  - class用于设置一个类的完全路径名称,主要作用是IOC容器生成类的实例
- Bean作用域 Scope属性
  - singleton 在SpringIOC容器中仅存在一个Bean实例,Bean以单实例的方式存在
  - prototype 每次调用getBean()时都会返回一个新的实例
  - require 每次HTPP请求都会创建一个新的Bean,该作用于仅用于WebApplicationContext环境
  - session 同一个HTTP Session共享一个Bean,不同的HTTP Session使用不同的Bean.该作用域仅适用于WebApplicationContext环境  
#### Bean的生命周期
> Spring初始化bean或销毁时,有时需要做一些处理工作,因此spring可以在创建和销毁bean的时候调用bean的两个生命周期方法
```
<bean id="xxx" class="..Yoo" init-method="init" destory-method="destroy"/>
```
- 完整生命周期
  - 1初始化
  - 2设置属性
  - 3如果Bean实现了BeanNameAware执行setBeanName
  - 4如果Bean实现了BeanFactoryAware或者ApplicationContextAware设置工厂setBeanFactory或者上下午对象setApplicationContext
  - 5设置Bean的名称
  - 6如果存在类实现BeanPostProcessor(后处理Bean),执行postProcessBeforeInitalization
  - 7如果Bean实现InitializingBean执行afterPropertiesSet
  - 8调用`<bean init-method="init">` 执行初始化init
  - 9如果存在实现BeanPostProcessor(处理Bean),执行postProcessAfterInitialization
  - 10执行业务逻辑
  - 11如果Bean实现DisposableBean 执行destroy
  - 12调用`<bean destroy-method="..">`执行销毁方法

#### BeanPostProcessor的作用
- 增类中某一个方法