package chapter2.v1;

import chapter2.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK8 之前的实现方式示例
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class App {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        List<Apple> greenApples = filterGreenApples(inventory);
        List<Apple> greenApples2 = filterApplesByColor(inventory, "green");
        List<Apple> redApples = filterApplesByColor(inventory, "red");

        List<Apple> heavyApples = filterApples(inventory, "", 150, false);
    }

    /**
     * 筛选绿苹果
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选苹果，把颜色作为参数
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选苹果，把重量作为参数
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 可以将颜色和重量结合为一个方法，不过就算这样，还是需要一种方式来区分想要筛选哪个属性。
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color,
                                           int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {// 十分笨拙的选择颜色或重量的方式
                result.add(apple);
            }
        }
        return result;
    }
}
