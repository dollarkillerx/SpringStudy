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
  ```
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步初始化前");
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        System.out.println("第八步:初始化后...");
        if ("userDao".equals(beanName)) {
            Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if ("save".equals(method.getName())) {
                        System.out.println("权限 校验");
                        return method.invoke(bean,args);
                    }
                    return method.invoke(bean,args);
                }
            });
            return proxy;
        }else{
            return bean;
        }
    }
  ```
#### Spring DI 依赖注入
- 构造函数注入
    - 通过构造方法注入Bean的属性值或依赖的对象,它保证了Bean实例在实例化后就可以使用了
    - 构造器注入在`<constructor-arg>`元素里声明的属性
- 属性setter方法注入
  - 通过`<property>`设置注入属性
```
    <!--Bean构造方法的属性注入-->
    <bean id="user" class="com.dollarkiller.ioc.demo4.User">
        <constructor-arg name="age" value="12"/>
        <constructor-arg name="name" value="张珊"/>
    </bean>

    <!-- set方法注入  在Spring配置文件中 通过<property>设置注入属性-->
    <bean id="person" class="com.dollarkiller.ioc.demo4.Person">
        <property name="name" value="万事达"/>
        <property name="age" value="16"/>
    </bean>

    <!-- 引入其他class ref= -->
    <bean id="person" class="com.dollarkiller.ioc.demo4.Person">
        <property name="name" value="万事达"/>
        <property name="age" value="16"/>
        <property name="cat" ref="cat"/>
    </bean>

    <bean id="cat" class="com.dollarkiller.ioc.demo4.Cat">
        <property name="name" value="小猫"/>
        <property name="age" value="3"/>
    </bean>
```
- p名称空间
  - 简化XML文件配置Spring2.5开始引用一个新的P名称空间
    - `xmlns:p="http://www.springframework.org/schema/p"`
  - p:<属性名称>="xxx" 引入常量
  - p:<属性名称>-ref="xxx" 引入其他Bean对象
```
    <!-- P名称空间注入-->
    <bean id="person" class="com.dollarkiller.ioc.demo4.Person" p:age="16" p:name="哈哈" p:cat-ref="cat"/>

    <bean id="cat" class="com.dollarkiller.ioc.demo4.Cat" p:name="小猫" p:age="3"/>
```
- SpEL的属性注入
  - SpEL:spring expression language,spring表达式语言,对依赖注入进行简化
  - 文法:#{表达式}
    - `<bean id="" value="#{表达式}">`
    - `#{'hello'}` 使用字符串
    - `#{beanId}` 使用另一个bean
    - `#{beanIdcontent.toUpperCase()}` 使用指定名属性,并使用方法
    - `#{T(java.lang.Math).PI}` 使用静态字段或方法
```
    <!-- SpEL空间注入-->
    <bean id="category" class="com.dollarkiller.ioc.demo4.Category">
        <property name="name" value="#{'服装'}"/>
    </bean>

    <bean id="productInfo" class="com.dollarkiller.ioc.demo4.ProductInfo"/>

    <bean id="product" class="com.dollarkiller.ioc.demo4.Product" >
        <property name="name" value="#{'男装'}"/>
        <property name="price" value="#{productInfo.calculatePrice()}"/>
        <property name="category" value="#{category}"/>
    </bean>
```
#### 复杂类型的属性注入
- 数组类型属性注入
- List集合类型属性注入
- Set集合类型属性注入
- Map结合类型属性注入
- Properties类型的属性注入
```
    <!-- 复杂类型属性注入注入-->
    <bean id="collectionBean" class="com.dollarkiller.ioc.demo5.CollectionBean">
        <!--数组类型-->
        <property name="arrs">
            <list>
                <value>aaa</value>
                <value>bbb</value>
                <value>ccc</value>
            </list>
        </property>
        <!--list集合属性注入-->
        <property name="list">
            <list>
                <value>1111</value>
                <value>2111</value>
                <value>3111</value>
                <value>4111</value>
            </list>
        </property>
        <!--set集合属性注入-->
        <property name="set">
            <set>
                <value>aaa</value>
                <value>baa</value>
                <value>caa</value>
                <value>ada</value>
            </set>
        </property>
        <!-- Map集合属性注入 -->
        <property name="map">
            <map>
                <entry key="aaa" value="111"></entry>
                <entry key="baa" value="222"></entry>
                <entry key="caa" value="333"></entry>
                <entry key="daa" value="444"></entry>
            </map>
        </property>
        <!--Properties属性注入-->
        <property name="properties">
            <props>
                <prop key="username">root</prop>
                <prop key="password">root</prop>
            </props>
        </property>
        
    </bean>
```
#### Bean的管理(注解方式)
- Spring2.5 引入使用注解方式定义Bean
- @Component 描述Spring框架中的Bean
- 约束
    ```
    <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context-3.0.xsd">
    ```
- 开始注解扫描
  - `<context:component-scan base-package="com.dollarkiller.demo1"/>`
    ```
    @Component("userService")
    public class UserService {
        public String seyHello(String name) {
            return "Hello" + name;
        }
    }
    ```
- 除了@Component外Spring提供了3个功能基本和@Componet等效的注解
  - @Repository 用于对DAO实现类进行标注
  - @Service 用于对Service实现类进行标注
  - @Controller 用于对Controller实现类进行标注
- 属性注入
  - @Autowred 默认安装类型注入
    - 如果两个相同Bean类型相同,则按照名称注入
  - @Autowired注入时可以针对成员变量或者set方法
  - 通过@Autowired的required属性,设置一定要找到匹配的Bean
  - 通过@Qualifier指定注入Bean的名称
  - 提供对JSR-250中定义的@Resource标注注解的支持
    ```
        @Autowired
        @Qualifier("userDao")
        private UserDao userDao;

        or

        @Resource(name="userDao")
        private UserDao userDao;
    ```
    - 类中如果有setter方法，那么注解需要加到setter方法上方，不可以加到getter方法上方。
- 其他注解
  - 生命周期
    ```
        <bean id="xxx" class="..Yoo" 
            init-method="init"
            destory-method="destroy">
    
        注解
        init 初始化
        @PostConstruce
        destroy 销毁
        @PreDestroy
    ```
- Bean的作用范围
  - 使用注解配置的Bean默认的作用范围是singleton
  - @Scope注解用于指定Bean的作用范围
```
@Component("demo2")
public class Demo2 {

@Component("bean1")
@Scope("prototype")
public class Bean1 {
```
- XML注解混用
  - 引入context命名空间
  - 配置文件添加context:annotation-config标签
  ```
    <!--单独使用属性注入的注解-->
    <context:annotation-config/>
  ```