package com.dollarkiller.sapectJ.demo2;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-20
 * Time: 下午3:15
 * Description: No Description
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void save() {
        System.out.println("save");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void findOne() {
        System.out.println("findOne");
    }

    @Override
    public void findAll() {
        System.out.println("findAll");
    }
}
