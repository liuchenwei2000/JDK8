package chapter2.v4;

import chapter2.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * 将 List 类型抽象化
 * <p>
 *    在通往抽象的路上，我们还可以更进一步。目前，filterApples 方法还只适用于 Apple。
 *    你还可以将List类型抽象化，从而超越你眼前要处理的问题
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class App {

    public interface Predicate<T> {
        boolean test(T t);
    }

    /**
     * 可以把 filter 方法用在香蕉、桔子、Integer 或是 String 的列表上了
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {// 引入类型参数T
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));

        List<Integer> numbers = new ArrayList<>();
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
    }
}
