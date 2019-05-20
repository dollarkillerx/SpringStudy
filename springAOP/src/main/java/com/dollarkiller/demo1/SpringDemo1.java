package com.dollarkiller.demo1;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-2
 * Time: 上午9:28
 * Description: No Description
 */
public class SpringDemo1 {
    @Test
    public void demo1() {
        UserDao userDao = new UserDaoImpl();
        UserDao proxy = (UserDao) new MyJdkProxy(userDao).createProxy();
        proxy.update();
        proxy.delete();
        proxy.save();

        proxy.find();
    }

}
