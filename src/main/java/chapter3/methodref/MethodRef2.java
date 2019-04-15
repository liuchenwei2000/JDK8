package chapter3.methodref;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 如何构建方法引用示例
 * <p>
 *     方法引用主要有三类。
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class MethodRef2 {

    public static void main(String[] args) {
        // 1，指向静态方法的方法引用
        Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);// Lambda 表达式
        f1 = Integer::parseInt;// 等价的方法引用

        // 2，指向任意类型实例方法的方法引用
        Function<String, Integer> f2 = (String s) -> s.length();// Lambda 表达式
        f2 = String::length;// 等价的方法引用

        // 3，指向现有对象的实例方法的方法引用
        Object obj = "hello";// 在 Lambda 中调用一个已经存在的外部对象中的方法
        Supplier<Integer> f3 = () -> obj.hashCode();// Lambda 表达式
        f3 = obj::hashCode;// 等价的方法引用
    }
}
