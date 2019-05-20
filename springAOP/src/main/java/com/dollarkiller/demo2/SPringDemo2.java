package com.dollarkiller.demo2;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-2
 * Time: 上午9:43
 * Description: No Description
 */
public class SPringDemo2 {
    @Test
    public void demo1() {
        ProductDao productDao = new ProductDao();
        ProductDao proxt = (ProductDao) new MyCglibProxy(productDao).createProxy();

        proxt.delete();
        proxt.find();
        proxt.save();

        proxt.update();
    }

}
