package com.dollarkiller.demo3;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-1
 * Time: 下午5:37
 * Description: No Description
 */
public class ProductService {
    @Resource(name = "categoryDao")
    private CategoryDao categoryDao;
    @Resource(name = "productDao")
    private ProductDao productDao;
    public void save() {
        System.out.println("ProductService的Save方法执行...");
        categoryDao.save();
        productDao.save();
    }
}
