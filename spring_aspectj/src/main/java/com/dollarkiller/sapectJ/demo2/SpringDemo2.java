package com.dollarkiller.sapectJ.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-20
 * Time: 下午3:23
 * Description: No Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext2.xml")
public class SpringDemo2 {
    @Resource(name = "customerDao")
    private CustomerDao customerDao;

    @Test
    public void demo1() {
        customerDao.save();
        customerDao.delete();
        customerDao.findAll();
        customerDao.findOne();
        customerDao.update();
    }
}
