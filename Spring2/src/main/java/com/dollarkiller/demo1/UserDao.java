package com.dollarkiller.demo1;

import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-1
 * Time: 下午4:50
 * Description: No Description
 */
@Repository("userDao")
public class UserDao {
    public void save() {
        System.out.println("保存用户");
    }
}
