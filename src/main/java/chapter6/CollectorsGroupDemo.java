package chapter6;

import chapter4.CaloricLevel;
import chapter4.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Collectors 分组示例
 * <p>
 *     用 Collectors.groupingBy 工厂方法返回的收集器就可以完成分组功能。
 * <p>
 * Created by liuchenwei on 2019-04-17.
 */
public class CollectorsGroupDemo {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.createDishList();
        // 最直接和最常用的收集器是 toList 静态方法，它会把流中所有的元素收集到一个 List 中
        // 给 groupingBy 方法传递了一个 Function（以方法引用的形式），它提取了流中每一道 Dish 的 Dish.Type。
        // 这个 Function 叫作分类函数，因为它用来把流中的元素分成不同的组。
        // 分组操作的结果是一个 Map，把分组函数返回的值作为映射的键，把流中所有具有这个分类值的项目的列表作为对应的映射值。
        Map<Dish.Type, List<Dish>> dishesByType = dishes.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        // 要实现多级分组，我们可以使用一个由双参数版本的 Collectors.groupingBy 工厂方法创建的收集器，
        // 它除了普通的分类函数之外，还可以接受 collector 类型的第二个参数。
        // 那么要进行二级分组的话，可以把一个内层 groupingBy 传递给外层 groupingBy，并定义一个为流中项目分类的二级标准，
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = dishes.stream().collect(
                Collectors.groupingBy(Dish::getType,// 一级分类函数
                        Collectors.groupingBy(dish -> {// 二级分类函数
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        })
                )
        );
        System.out.println(dishesByTypeCaloricLevel);

        // list to map<key,list>

        Map<Dish.Type, List<Integer>> map = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getCalories, Collectors.toList())));
        for (Dish.Type type : map.keySet()) {
            System.out.println(type + "=" + map.get(type));
        }
    }
}
