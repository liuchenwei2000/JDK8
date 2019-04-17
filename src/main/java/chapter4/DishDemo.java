package chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Stream API 对比
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-16.
 */
public class DishDemo {

    public static void main(String[] args) {
        List<Dish> menu = Dish.createDishList();

        /** 功能需求：返回小于 400 热量的菜肴名称，并按照卡路里排序 **/

        /** JDK8 之前的实现方式 */
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : menu) {
            if (d.getCalories() < 400) {// 用累加器筛选元素
                lowCaloricDishes.add(d);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {// 用匿名类对菜肴排序
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());// 处理排序后的菜名列表
        }
        System.out.println(lowCaloricDishesName);

        /** JDK8 的实现方式 */
        lowCaloricDishesName = menu.stream()
                .filter(d -> d.getCalories() < 400)// 选出400卡路里以下的菜肴
                .sorted(comparing(Dish::getCalories)) // 按照卡路里排序
                .map(Dish::getName)// 提取菜肴的名称
                .collect(toList());// 将所有名称保存在List中
        System.out.println(lowCaloricDishesName);

        /**
         * Stream API 的好处
         *
         * 代码是以声明性方式写的：说明想要完成什么（筛选热量低的菜肴）而不是说明如何实现一个操作（利用循环和if条件等控制流语句）。
         * 这种方法加上行为参数化让你可以轻松应对变化的需求：你很容易再创建一个代码版本，利用 Lambda 表达式来筛选高卡路里的菜肴，而用不着去复制粘贴代码。
         *
         * 可以把几个基础操作链接起来，来表达复杂的数据处理流水线（在 filter 后面接上 sorted、map 和 collect 操作，同时保持代码清晰可读。
         * filter 的结果被传给了 sorted 方法，再传给 map 方法，最后传给 collect 方法。
         */
    }
}
