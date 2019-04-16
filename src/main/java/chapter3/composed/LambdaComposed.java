package chapter3.composed;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * Lambda 复合示例
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-16.
 */
public class LambdaComposed {

    public static void main(String[] args) {
        /** 比较器复合 */
        List<String> strList = Arrays.asList("hello", "world", "lambda");
        // 按字符串长度排序
        strList.sort(comparing(String::length));
        // 按字符串长度逆序排序
        strList.sort(comparing(String::length).reversed());
        // 比较器链，先按字符串长度逆序排序，如果长度相同再按 hashCode 排序
        strList.sort(comparing(String::length).reversed().thenComparing(String::hashCode));

        /** 谓词复合，谓词接口包括三个方法：negate、and 和 or，可以重用已有的 Predicate 来创建更复杂的谓词。 */
        Predicate<String> nullStringPredicate = (String s) -> s.isEmpty();
        Predicate<String> notNullStringPredicate = nullStringPredicate.negate();// 取非
        // 且或关系，and和or方法是按照在表达式链中的位置，从左向右确定优先级的
        nullStringPredicate.and(notNullStringPredicate).or(notNullStringPredicate);

        /**
         * 函数复合，可以把 Function 接口所代表的 Lambda 表达式复合起来。
         * Function 接口为此配了 andThen 和 compose 两个默认方法，它们都会返回 Function 的一个实例。
         */

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        // andThen 方法会返回一个函数，它先对输入应用一个给定函数，再对输出应用另一个函数。
        Function<Integer, Integer> h = f.andThen(g);// 数学上会写作 g(f(x))
        int result = h.apply(1);// 4

        Function<Integer, Integer> h2 = f.compose(g);// 数学上会写作 f(g(x))
        result = h.apply(1);// 3
    }
}
