package chapter6;

import chapter4.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Collectors 分区示例
 * <p>
 *     分区是分组的特殊情况：由一个谓词（返回一个布尔值的函数）作为分类函数，它称分区函数。
 *     分区函数返回一个布尔值，这意味着得到的分组 Map 的键类型是 Boolean，
 *     它最多可以分为两组，true 是一组，false 是一组。
 * <p>
 * Created by liuchenwei on 2019-04-17.
 */
public class CollectorsPartitionDemo {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.createDishList();
        // 分区的好处在于保留了分区函数返回 true 或 false 的两套流元素列表。
        Map<Boolean, List<Dish>> partitionedMenu =
                dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);

        // partitioningBy 工厂方法有一个重载版本，可以像下面这样传递第二个收集器
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                dishes.stream().collect(
                        Collectors.partitioningBy(Dish::isVegetarian,// 分区函数
                                Collectors.groupingBy(Dish::getType)));// 第二个收集器
        System.out.println(vegetarianDishesByType);
    }
}
