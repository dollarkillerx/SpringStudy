package com.dollarkiller.demo2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-1
 * Time: 下午5:08
 * Description: No Description
 */
@Component("demo2")
public class Demo2 {
    @PostConstruct
    public void init() {
        System.out.println("init bean ...");
    }

    public void say() {
        System.out.println("say ...");
    }

    @PreDestroy
    public void destory() {
        System.out.println("destory bean ....");
    }


}
