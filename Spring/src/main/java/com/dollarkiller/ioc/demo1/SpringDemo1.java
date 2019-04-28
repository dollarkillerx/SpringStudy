package com.dollarkiller.ioc.demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import sun.awt.X11.XMapEvent;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-4-25
 * Time: 下午9:40
 * Description: No Description
 */
public class SpringDemo1 {
    @Test // 传统方式
    public void demo1(){
        UserService userService = new UserServiceImpl();
        userService.sayHello();
    }

    @Test//Spring实现方式
    public void demo2() {
        // 创建spring的工厂
        ApplicationContext appletContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过工厂获得类:
        UserService userService = (UserService) appletContext.getBean("userService");
        userService.sayHello();
    }

    @Test
    /**
     * 读取磁盘系统的配置文件
     */
    public void demo3() {
        //创建Spring工厂类
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("/home/dollarkiller/github/SpringStudy/Spring/src/main/resources/applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();
    }

    @Test
    /**
     * 传统方式创建工厂类
     */
    public void demo4() {
        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource(""));
    }

}
