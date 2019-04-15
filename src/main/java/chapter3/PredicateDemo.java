package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate 函数式接口
 * <p>
 *     java.util.function.Predicate<T> 接口定义了一个名叫 test 的抽象方法，它接受泛型T对象，并返回一个boolean。
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class PredicateDemo {

    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("a", "b");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
}
