package com.dollarkiller.ioc.demo1.test;

/**
 * Created with IntelliJ IDEA.
 * User: dollarkiller
 * Date: 19-4-25
 * Time: 下午10:37
 * Description: No Description
 */
public class Food{
    public String foodName;
    public String foodTaste;
    public String foodKind;

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", foodTaste='" + foodTaste + '\'' +
                ", foodKind='" + foodKind + '\'' +
                '}';
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodTaste(String foodTaste) {
        this.foodTaste = foodTaste;
    }

    public void setFoodKind(String foodKind) {
        this.foodKind = foodKind;
    }
}