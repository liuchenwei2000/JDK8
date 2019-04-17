package chapter5.builder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 构建流示例
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-17.
 */
public class BuildStreamDemo {

    public static void main(String[] args) {
        // 1，由值创建流
        // 使用静态方法 Stream.of，通过显式值创建一个流，它可以接受任意数量的参数。
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        // 2，由数组创建流
        // 使用静态方法 Arrays.stream 从数组创建一个流，它接受一个数组作为参数。
        int[] numbers = {5, 4, 3, 2, 1};
        IntStream intStream = Arrays.stream(numbers);
        intStream.forEach(System.out::println);
        // 3，由文件创建流
        // Java 中用于处理文件等 I/O 操作的 NIO API（非阻塞 I/O）已更新，以便利用 Stream API。
        // java.nio.file.Files 中的很多静态方法都会返回一个流。
        // 例如 Files.lines 它会返回一个由指定文件中的各行构成的字符串流。
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("pom.xml"), Charset.defaultCharset())) {// 流会自动关闭
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))// 生成单词流
                    .distinct()// 删除重复项
                    .count();//数一数有多少各不相同的单词
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(uniqueWords);
    }
}
