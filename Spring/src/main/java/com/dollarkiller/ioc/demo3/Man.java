package com.dollarkiller.ioc.demo3;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-4-28
 * Time: 下午9:51
 * Description: No Description
 */
public class Man {

    public Man(){
        System.out.println("Man被实例化了...");
    }
    public void setup() {
        System.out.println("Man被初始化了");
    }
    public void teardown() {
        System.out.println("Man被销毁了");
    }

}
