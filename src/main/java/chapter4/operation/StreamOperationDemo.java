package chapter4.operation;

import chapter4.Dish;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 流操作示例
 * <p>
 *     Stream 接口定义了许多操作，它们可以分为两大类：中间操作和终端操作。
 *     可以连接起来的流操作称为中间操作，关闭流的操作称为终端操作。
 * <p>
 * Created by liuchenwei on 2019-04-16.
 */
public class StreamOperationDemo {

    public static void main(String[] args) {
        List<Dish> menu = Dish.createDishList();
       /**
        * 中间操作会返回另一个流。这让多个操作可以连接起来形成一个查询。
        * 重要的是，除非流水线上触发一个终端操作，否则中间操作不会执行任何处理（它们很懒）。
        * 这是因为中间操作一般都可以合并起来，在终端操作时一次性全部处理。
        * 中间操作有：filter、map、limit、sorted、distinct
        */
        List<String> names = menu.stream()
                .filter(d -> d.getCalories() > 300)// 中间操作
                .map(Dish::getName)// 中间操作
                .limit(3)// 中间操作
                .collect(toList());// 终端操作

        /**
         * 终端操作会从流的流水线生成结果。其结果是任何不是流的值，比如 List、Integer，甚至void。
         * 例如，在下面的流水线中，forEach 是一个返回 void 的终端操作，它会对源中的每道菜应用一个 Lambda。
         * 终端操作有：forEach、count、collect
         */
        names.stream().forEach(System.out::println);

        /**
         * 流的使用一般包括三件事：
         *
         * 一个数据源（如集合）来执行一个查询；
         * 一个中间操作链，形成一条流的流水线；
         * 一个终端操作，执行流水线，并能生成结果。
         *
         * 流的流水线背后的理念类似于构建器（builder）模式。
         * 在构建器模式中有一个调用链用来设置一套配置（对流来说这就是一个中间操作链），
         * 接着是调用 build 方法（对流来说就是终端操作）。
         */
    }
}
