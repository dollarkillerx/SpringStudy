package com.dollarkiller.sapectJ.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-20
 * Time: 上午11:01
 * Description: No Description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo1Test {

    @Resource(name="productDao")
    private ProductDao productDao;

    @Test
    public void demo1(){
        productDao.delete();
        productDao.save();
        productDao.update();
        productDao.findAll();
        try {
            productDao.findOne();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
