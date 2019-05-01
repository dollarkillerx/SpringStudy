package com.dollarkiller.demo1;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-1
 * Time: 下午4:29
 * Description: No Description
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Spring的Bean管理注解方式
 *  传统方式区XML配置<bean id="" class=""></bean>
 */

@Component("userService")
public class UserService {
    @Value("米饭")
    private String food;
//    @Autowired
//    @Qualifier("userDao")
    @Resource(name="userDao")
    private UserDao userDao;

    public String seyHello(String name) {
        return "Hello" + name;
    }
    public void eat() {
        System.out.println("eat:" + food);
    }
    public void save() {
        System.out.println("Service中保存用户..");
        userDao.save();
    }
}
