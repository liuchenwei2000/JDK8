package chapter5.intstream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 数值流 IntStream 操作示例
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-17.
 */
public class IntStreamDemo {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "lambda");
        // 映射到数值流，将流转换为特化版本的常用方法是 mapToInt、mapToDouble 和 mapToLong。
        // 这些方法和前面说的 map 方法的工作方式一样，只是它们返回的是一个特化流，而不是 Stream<T>。
        // mapToInt 返回一个 IntStream（而不是一个Stream<Integer>）。然后就可以调用 IntStream 接口中定义的 sum 方法
        // 请注意，如果流是空的，sum 默认返回 0。IntStream 还支持其他的方便方法，如 max、min、average 等。
        int sum = words.stream().mapToInt(d -> d.length()).sum();
        System.out.println(sum);

        // Optional 可以用 Integer、String 等参考类型来参数化。
        // 对于三种原始流特化，也分别有一个 Optional 原始类型特化版本：OptionalInt、OptionalDouble 和 OptionalLong。
        OptionalInt max = words.stream().mapToInt(d -> d.length()).max();
        max.ifPresent(System.out::println);
        OptionalInt min = words.stream().mapToInt(d -> d.length()).min();
        min.ifPresent(System.out::println);
        OptionalDouble average = words.stream().mapToInt(d -> d.length()).average();
        average.ifPresent(System.out::println);

        // 把原始流转换成一般流（每个 int 都会装箱成一个 Integer），可以使用 boxed 方法
        Stream<Integer> boxed = words.stream().mapToInt(d -> d.length()).boxed();

        // IntStream 和 LongStream 的静态方法 range 和 rangeClosed 可以帮助生成数值范围。
        // 这两个方法都是第一个参数接受起始值，第二个参数接受结束值。但 range 是不包含结束值的，而 rangeClosed 则包含结束值。
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)// 表示范围[1, 100]
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());
    }
}
