package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 查找与匹配示例
 * <p>
 *     另一个常见的数据处理套路是看看数据集中的某些元素是否匹配一个给定的属性。
 *     Stream API 通过 allMatch、anyMatch、noneMatch、findFirst 和 findAny 方法提供了这样的工具。
 * <p>
 * Created by liuchenwei on 2019-04-17.
 */
public class MatchDemo {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("a", "b", "c", "x", "y", "z");
        // anyMatch 方法可以回答“流中是否有一个元素能匹配给定的谓词”。这是一个终端操作。
        boolean hasEmptyStr = words.stream().anyMatch(String::isEmpty);
        // allMatch 方法会看看流中的元素是否都能匹配给定的谓词。
        boolean allStrIsNotEmpty = words.stream().allMatch(d -> d.length() > 0);
        // noneMatch 方法确保流中没有任何元素与给定的谓词匹配。
        boolean allStrIsSingleChar = words.stream().noneMatch(d -> d.length() > 1);
        // findAny 方法将返回当前流中的任意元素。
        Optional<String> randomStr = words.stream().findAny();
        randomStr.ifPresent(r -> System.out.println(r));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        // 有些流有一个出现顺序（encounter order）来指定流中项目出现的逻辑顺序。
        // 对于这种流，你可能想要找到第一个元素。为此有一个 findFirst 方法，它的工作方式类似于 findany。
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst(); // 9
    }
}
