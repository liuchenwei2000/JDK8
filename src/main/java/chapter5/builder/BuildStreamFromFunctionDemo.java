package chapter5.builder;

import java.util.stream.Stream;

/**
 * 由函数生成流：创建无限流示例
 * <p>
 *     Stream API 提供了两个静态方法来从函数生成流：Stream.iterate 和 Stream.generate。
 *     这两个操作可以创建所谓的无限流：不像从固定集合创建的流那样有固定大小的流。
 *     由 iterate 和 generate 产生的流会用给定的函数按需创建值，因此可以无穷无尽地计算下去。
 *     一般来说，应该使用 limit(n) 来对这种流加以限制，以避免打印无穷多个值。
 * <p>
 * Created by liuchenwei on 2019-04-17.
 */
public class BuildStreamFromFunctionDemo {

    public static void main(String[] args) {
        // iterate 方法接受一个初始值（在这里是0），还有一个依次应用在每个产生的新值上的 Lambda
        // 请注意，此操作将生成一个无限流，它没有结尾，因为值是按需计算的，可以永远计算下去。
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // generate 方法也可按需生成一个无限流。但 generate 不是依次对每个新生成的值应用函数的。
        // 它接受一个 Supplier<T> 类型的 Lambda 提供新的值。
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
