package chapter5.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * reduce 操作示例
 * <p>
 *     map 和reduce 的连接通常称为map-reduce模式，因为它很容易并行化。
 * <p>
 * Created by liuchenwei on 2019-04-17.
 */
public class ReduceDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        // JDK8 之前的求和实现
        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }
        System.out.println(sum);
        // JDK8 使用 reduce 实现
        // reduce接受两个参数：
        // 一个初始值，这里是0。一个 BinaryOperator<T> 来将两个元素结合起来产生一个新值，这里我们用的是 lambda (a, b) -> a + b。
        // Lambda 反复结合每个元素，直到流被归约成一个值。
        Optional<Integer> sumOp = numbers.stream().reduce((a, b) -> a + b);
        sumOp.ifPresent(System.out::println);
        // Integer 类现在有了一个静态的 sum 方法来对两个数求和，所以可以直接使用
        sumOp = numbers.stream().reduce(Integer::sum);
        sumOp.ifPresent(System.out::println);

        // Integer 类还提供了静态的 max 方法和 min 方法，用于 reduce 操作
        Optional<Integer> maxOp = numbers.stream().reduce(Integer::max);
        maxOp.ifPresent(System.out::println);
        Optional<Integer> minOp = numbers.stream().reduce(Integer::min);
        minOp.ifPresent(System.out::println);
    }
}
