package chapter3.methodref;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 方法引用示例
 * <p>
 *     方法引用可以被看作仅仅调用特定方法的 Lambda 的一种快捷写法。
 *     它的基本思想是，如果一个 Lambda 代表的只是“直接调用这个方法”，那最好还是用名称来调用它，而不是去描述如何调用它。
 *     事实上，方法引用就是让你根据已有的方法实现来创建 Lambda 表达式。但是，显式地指明方法的名称，你的代码的可读性会更好。
 *     它是如何工作的呢？当你需要使用方法引用时，目标引用放在分隔符 :: 前，方法的名称放在后面。
 *     例如，Apple::getWeight 就是引用了 Apple 类中定义的方法 getWeight。
 *     记住，不需要括号，因为你没有实际调用这个方法。方法引用就是 Lambda 表达式(Apple a) -> a.getWeight()的快捷写法。
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class MethodRef1 {

    public static void main(String[] args) {
        // 可以把方法引用看作针对仅仅涉及单一方法的 Lambda 的语法糖，因为你表达同样的事情时要写的代码更少了。
        Function<String, Integer> processor = (String s) -> s.length();// Lambda 表达式
        processor = String::length;// 等价的方法引用

        Consumer<String> processor1 = (String s) -> System.out.println(s);// Lambda 表达式
        processor1 = System.out::println;// 等价的方法引用
    }
}
