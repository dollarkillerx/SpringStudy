package com.dollarkiller.ioc.demo4;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-1
 * Time: 下午2:53
 * Description: No Description
 */
public class User {
    private String name;
    private Integer age;

    public User(String name,Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
