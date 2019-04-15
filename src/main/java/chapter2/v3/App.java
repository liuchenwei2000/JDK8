package chapter2.v3;

import chapter2.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用匿名类
 * <p>
 *    v2 版本中，当要把新的行为传递给 filterApples 方法的时候，
 *    你不得不声明好几个实现 ApplePredicate 接口的类，然后实例化好几个只会用到一次的 ApplePredicate 对象。
 *    这真是很啰嗦，很费时间！Java有一个机制称为匿名类，它可以让你同时声明和实例化一个类。
 *    它可以帮助你进一步改善代码，让它变得更简洁。但这也不完全令人满意。
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class App {

    /**
     * 可以用 ApplePredicate 的多个实现代表不同的选择标准
     */
    public interface ApplePredicate{

        boolean test(Apple apple);
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {// 谓词对象封装了测试苹果的条件
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        // 使用匿名类，仍然很笨重，占用很多空间，且让人不容易理解。
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        // 使用 Lambda 表达式，不得不承认这代码看上去比先前干净很多
        List<Apple> redApples2 = filterApples(inventory, apple -> "red".equals(apple.getColor()));
    }
}
