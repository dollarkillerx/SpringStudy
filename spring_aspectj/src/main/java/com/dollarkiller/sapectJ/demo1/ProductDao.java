package com.dollarkiller.sapectJ.demo1;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-3
 * Time: 上午11:02
 * Description: No Description
 */
public class ProductDao {

    public void save() {
        System.out.println("this is save product");
    }

    public String  update() {
        System.out.println("modify product");
        return "hello";
    }

    public void delete() {
        System.out.println("delete goods");
    }

    public void findOne() throws Exception {
        System.out.println("select one goods");
        throw new Exception("hh");
    }

    public void findAll() {
        System.out.println("select * goods");
    }
}
