package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Function 函数式接口
 * <p>
 *     java.util.function.Function<T, R> 接口定义了一个叫作 apply 的方法，它接受一个泛型 T 的对象，并返回一个泛型 R 的对象。
 *     如果你需要定义一个 Lambda，将输入对象的信息映射到输出，就可以使用这个接口。
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class FunctionDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("lambdas", "in", "action");
        // Lambda 是 Function 中 apply 方法的实现
        List<Integer> result = map(list, (String s) -> s.length());
        System.out.println(result);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }
}
