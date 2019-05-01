package com.dollarkiller.ioc.demo3;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-4-29
 * Time: 下午8:19
 * Description: No Description
 */
public class UserDaoImpl implements UserDao{

    public void findAll() {
        System.out.println("查询用户...");
    }

    public void save() {
        System.out.println("保存用户");
    }

    public void update() {
        System.out.println("修改用户...");
    }

    public void delete() {
        System.out.println("删除用户...");
    }
}
