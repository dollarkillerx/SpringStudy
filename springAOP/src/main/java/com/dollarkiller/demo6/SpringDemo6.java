package com.dollarkiller.demo6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-3
 * Time: 上午10:13
 * Description: No Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class SpringDemo6 {
    @Resource(name = "studentDao")
    private StudentDao studentDao;
    @Resource(name = "customerDao")
    private CustomerDao customerDao;
    @Test
    public void demo1() {
        studentDao.find();
        studentDao.save();
        studentDao.update();
        studentDao.delete();

        customerDao.delete();
        customerDao.find();
        customerDao.save();
        customerDao.update();
    }
}
