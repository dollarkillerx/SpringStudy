package com.dollarkiller.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-2
 * Time: 上午10:41
 * Description: No Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo3 {
//    @Resource(name="studentDao")
    @Resource(name = "studentDaoProxy")
    private StudentDao studentDao;

    @Test
    public void test1() {
        studentDao.delete();
        studentDao.save();
        studentDao.update();
        studentDao.find();
    }
}
