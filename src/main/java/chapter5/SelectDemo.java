package chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * 筛选示例
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-16.
 */
public class SelectDemo {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        // Streams 接口支持 filter 方法。
        // 该操作会接受一个谓词（一个返回 boolean 的函数）作为参数，
        // 并返回一个包括所有符合谓词的元素的流。
        integers.stream()
                .filter(n -> n > 5)
                .forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        // 流还支持一个叫作 distinct 的方法，它会返回一个元素各异（根据流所生成元素的 hashCode 和 equals 方法实现）的流。
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
