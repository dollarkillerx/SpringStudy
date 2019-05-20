package com.dollarkiller.demo4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-2
 * Time: 下午3:20
 * Description: No Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class SpringDemo4 {
//    @Resource(name = "customerDao")
    @Resource(name = "customerDaoProxy")
    private CustomerDao customerDao;

    @Test
    public void demo1() {
        customerDao.find();
        customerDao.save();
        customerDao.update();
        customerDao.delete();
    }

}
