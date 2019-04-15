package chapter2.v2;

import chapter2.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * 跟 v1 版本相比，需要一种比添加很多参数更好的方法来应对变化的需求。
 * <p>
 *  让我们后退一步来看看更高层次的抽象。一种可能的解决方案是对你的选择标准建模：
 *  你考虑的是 Apple，需要根据 Apple 的某些属性（比如它是绿色的吗？重量超过150克吗？）来返回一个boolean值。
 *  我们把它称为谓词（即一个返回 boolean 值的函数）。
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class App {

    /**
     * 可以用 ApplePredicate 的多个实现代表不同的选择标准
     */
    public interface ApplePredicate{

        boolean test (Apple apple);
    }

    /**
     * 仅仅选出重的苹果
     */
    public static class AppleHeavyWeightPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    /**
     * 仅仅选出绿苹果
     */
    public static class AppleGreenColorPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    /**
     * 行为参数化：让方法接受多种行为（或策略）作为参数，并在内部使用，来完成不同的行为。
     * 由于该 filterApples 方法只能接受对象，所以必须把代码包裹在 ApplePredicate 对象里。
     * 你的做法就类似于在内联“传递代码”，因为你是通过一个实现了 test 方法的对象来传递布尔表达式的。
     */
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
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
    }
}
