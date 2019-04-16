package chapter5;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 映射示例
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-16.
 */
public class MappingDemo {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("a", "b", "c", "x", "y", "z");
        // 流支持 map 方法，它会接受一个函数作为参数。这个函数会被应用到每个元素上，并将其映射成一个新的元素
        words.stream()
                .map(c -> c.toUpperCase())
                .forEach(System.out::println);

        List<String> arrayOfWords = Arrays.asList("Goodbye", "World");
        // 使用 flatMap 方法的效果是，各个数组并不是分别映射成一个流，而是映射成流的内容。
        // 所有使用 map(Arrays::stream) 时生成的单个流都被合并起来，即扁平化为一个流。
        arrayOfWords.stream()
                .map(word -> word.split(""))// 将每个单词转换为由其字母构成的数组
                .flatMap(Arrays::stream)// 将各个生成流扁平化为单个流
                .distinct()
                .forEach(System.out::println);
    }
}
