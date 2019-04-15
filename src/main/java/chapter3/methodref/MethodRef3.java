package chapter3.methodref;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造函数引用
 * <p>
 *     对于一个构造函数，可以利用它的名称和关键字 new 来创建它的一个引用：ClassName::new。
 *     它的功能与指向静态方法的引用类似。
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class MethodRef3 {

    public static void main(String[] args) {
        Supplier<Orange> c1 = Orange::new;// 构造函数引用指向默认的 Orange() 构造函数，等价于下面的 Lambda 表达式
//        Supplier<Orange> c1 = () -> new Orange();
        Orange a1 = c1.get();// 调用 Supplier 的 get 方法将产生一个新的 Orange

        Function<Integer, Orange> c2 = Orange::new;// 指向 Orange(Integer weight)的构造函数，等价于下面的 Lambda 表达式
//        Function<Integer, Orange> c2 = (weight) -> new Orange(weight);
        Orange a2 = c2.apply(110);// 调用该 Function 函数的 apply 方法
    }


    public static class Orange {

        private int weight;

        public Orange() {
        }

        public Orange(int weight) {
            this.weight = weight;
        }
    }
}
