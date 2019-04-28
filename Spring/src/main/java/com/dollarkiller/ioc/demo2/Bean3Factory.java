package com.dollarkiller.ioc.demo2;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-4-28
 * Time: 下午9:08
 * Description: No Description
 */


/**
 * Bean的实例化三种方式:实例工厂实例化
 */
public class Bean3Factory {
    public Bean3 createBean3() {
        System.out.println("Bean3的工厂已经被执行了");
        return new Bean3();
    }
}
