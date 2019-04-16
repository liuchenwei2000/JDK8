package chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * 切片示例
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-16.
 */
public class SliceDemo {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        // 流支持 limit(n) 方法，该方法会返回一个不超过给定长度的流。
        // 所需的长度作为参数传递给 limit。如果流是有序的，则最多会返回前n个元素。
        // 请注意 limit 也可以用在无序流上，比如源是一个 Set。这种情况下，limit 的结果不会以任何顺序排列。
        integers.stream()
                .filter(n -> n > 5)
                .limit(2)
                .forEach(System.out::println);

        // 流还支持 skip(n) 方法，返回一个扔掉了前 n 个元素的流。
        // 如果流中元素不足 n 个，则返回一个空流。请注意，limit(n) 和 skip(n)是互补的
        integers.stream()
                .filter(n -> n > 5)
                .skip(2)
                .forEach(System.out::println);
    }
}
