package chapter7;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * 并行流示例
 * <p>
 *     求前 n 个数字和的不同实现方式
 * <p>
 * Created by liuchenwei on 2019-04-22.
 */
public class ParallelStreamDemo {

    public static void main(String[] args) {
        long n = 1256859689L;

        long begin = System.currentTimeMillis();
        System.out.println(iterativeSum(n));
        long end = System.currentTimeMillis();
        System.out.println((end - begin) + " ms");

        begin = System.currentTimeMillis();
        System.out.println(sequentialSum(n));
        end = System.currentTimeMillis();
        System.out.println((end - begin) + " ms");

        begin = System.currentTimeMillis();
        System.out.println(parallelSum(n));
        end = System.currentTimeMillis();
        System.out.println((end - begin) + " ms");

        // 获取集合的并行流
        Integer sum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).parallelStream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    /**
     * 传统方式求和
     */
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    /**
     * 顺序流方式求和
     */
    public static long sequentialSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    /**
     * 并行流方式求和
     * <p>
     * 对顺序流调用 parallel 方法并不意味着流本身有任何实际的变化。
     * 它在内部实际上就是设了一个 boolean 标志，表示你想让调用 parallel 之后进行的所有操作都并行执行。
     * 类似地，你只需要对并行流调用 sequential 方法就可以把它变成顺序流。
     * 请注意，你可能以为把这两个方法结合起来，就可以更细化地控制在遍历流时哪些操作要并行执行，哪些要顺序执行。
     * <p>
     * 并行流内部使用了默认的 ForkJoinPool ，它默认的线程数量就是你的处理器数量，
     * 这个值是由 Runtime.getRuntime().availableProcessors() 得到的。
     */
    public static long parallelSum(long n) {
        // 下面的实现方式涉及到大量的 boxing 和 unboxing，性能不如 LongStream.rangeClosed
        // Java 8中有原始类型流（IntStream、LongStream、DoubleStream）来避免这种操作，但凡有可能都应该用这些流。
//        return Stream.iterate(1L, i -> i + 1)
//                .limit(n)
//                .parallel()// 将流转换为并行流
//                .reduce(0L, Long::sum);

        return LongStream.rangeClosed(1, n)
                .parallel()// 将流转换为并行流
                .reduce(0L, Long::sum);
    }
}
