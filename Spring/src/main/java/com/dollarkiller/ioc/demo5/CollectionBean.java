package com.dollarkiller.ioc.demo5;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-5-1
 * Time: 下午4:01
 * Description: No Description
 */
public class CollectionBean {
    private String[] arrs;//数组类型
    private List<String> list;// list集合类型
    private Set<String> set;// set集合类型
    private Map<String,Integer> map;//map集合类型
    private Properties properties;// properties属性

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                "arrs=" + Arrays.toString(arrs) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
