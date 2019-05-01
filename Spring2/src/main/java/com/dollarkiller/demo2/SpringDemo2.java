package com.dollarkiller.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-1
 * Time: 下午5:11
 * Description: No Description
 */
public class SpringDemo2 {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo2 demo2 = (Demo2) applicationContext.getBean("demo2");
        demo2.say();
        applicationContext.close();
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean1 bean1 = (Bean1)applicationContext.getBean("bean1");
        Bean1 bean2 = (Bean1)applicationContext.getBean("bean1");
        System.out.println(bean1);
        System.out.println(bean2);
    }
}
