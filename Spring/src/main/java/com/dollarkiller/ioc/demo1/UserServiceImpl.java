package com.dollarkiller.ioc.demo1;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-4-25
 * Time: 下午9:38
 * Description: No Description
 */
public class UserServiceImpl implements UserService{
    public String name;

    public void sayHello() {
        System.out.println("Hello Spring" + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
