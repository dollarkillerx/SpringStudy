package com.dollarkiller.ioc.demo3;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-4-28
 * Time: 下午9:30
 * Description: No Description
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean Scope
 */
public class SpringDemo3 {
    @Test
    public void demo() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person1 = (Person)applicationContext.getBean("person");
        Person person2 = (Person)applicationContext.getBean("person");
        System.out.println(person1);
        System.out.println(person2);
    }
    @Test
    public void demo1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Man man = (Man)applicationContext.getBean("man");
        System.out.println(man);
    }

}
