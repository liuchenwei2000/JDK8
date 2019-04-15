package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer 函数式接口
 * <p>
 *     java.util.function.Consumer<T> 定义了一个名叫 accept 的抽象方法，它接受泛型T的对象，没有返回（void）。
 *     如果需要访问类型 T 的对象，并对其执行某些操作，就可以使用这个接口。
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // Lambda 是 Consumer 中 accept 方法的实现
        forEach(list, (Integer i) -> System.out.println(i));
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}
