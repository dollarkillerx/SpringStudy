package com.dollarkiller.ioc.demo1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-4-25
 * Time: 下午10:42
 * Description: No Description
 */
public class Test {
    @org.junit.Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Food food = (Food)applicationContext.getBean("food");
        food.toString();
    }
}
