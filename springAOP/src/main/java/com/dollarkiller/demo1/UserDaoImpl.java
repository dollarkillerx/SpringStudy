package com.dollarkiller.demo1;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-2
 * Time: 上午9:26
 * Description: No Description
 */
public class UserDaoImpl implements UserDao{
    public void save() {
        System.out.println("保存用户...");
    }

    public void update() {
        System.out.println("修改用户...");
    }

    public void delete() {
        System.out.println("删除用户...");
    }

    public void find() {
        System.out.println("查询用户...");
    }
}
