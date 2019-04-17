package chapter6;

import chapter4.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Collectors 归约和汇总示例
 * <p>
 *     Collectors 类提供的工厂方法创建的收集器。它们主要提供了三大功能：
 *     将流元素归约和汇总为一个值、元素分组、元素分区。
 * <p>
 *     在需要将流项目重组成集合时，一般会使用收集器（Stream.collect 方法的参数）。
 *     再宽泛一点来说，但凡要把流中所有的项目合并成一个结果时就可以用。
 * <p>
 * Created by liuchenwei on 2019-04-17.
 */
public class CollectorsDemo {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.createDishList();
        // 最直接和最常用的收集器是 toList 静态方法，它会把流中所有的元素收集到一个 List 中
        List<Dish> dishList1 = dishes.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(dishList1);

        // 利用 counting 工厂方法返回的收集器，数一数菜单里有多少种菜
        long howManyDishes = dishes.stream().collect(Collectors.counting());
        long howManyDishes2 = dishes.stream().count();// 更简洁的写法
        System.out.println(howManyDishes + " " + howManyDishes2);

        // Collectors.maxBy 和 Collectors.minBy 来计算流中的最大或最小值。
        // 这两个收集器接收一个 Comparator 参数来比较流中的元素。
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = dishes.stream()
                        .collect(Collectors.maxBy(dishCaloriesComparator));
        mostCalorieDish.ifPresent(System.out::println);

        // Collectors.summingInt 接受一个把对象映射为求和所需 int 的函数，并返回一个收集器；
        // 该收集器在传递给普通的 collect 方法后即执行需要的汇总操作。
        int totalCalories = dishes.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        // Collectors.averagingInt 连同对应的 averagingLong 和 averagingDouble 可以计算数值的平均数
        double avgCalories = dishes.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        // 很多时候，你可能想要得到两个或更多这样的结果，而且你希望只需一次操作就可以完成。
        // 在这种情况下，可以使用 summarizingInt 工厂方法返回的收集器。
        IntSummaryStatistics menuStatistics = dishes.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        // Collectors.joining 方法返回的收集器会把对流中每一个对象应用 toString 方法得到的所有字符串连接成一个字符串。
        String shortMenu = dishes.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(shortMenu);
    }
}
