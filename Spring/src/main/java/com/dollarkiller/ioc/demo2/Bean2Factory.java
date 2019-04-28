package com.dollarkiller.ioc.demo2;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-4-27
 * Time: 上午9:42
 * Description: No Description
 */
public class Bean2Factory {

    public static Bean2 createBean2() {
        System.out.println("Bean2 create");
        return new Bean2();
    }
}
