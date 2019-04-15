package chapter3;

/**
 * 在哪里以及如何使用 Lambda
 * <p>
 *     可以在函数式接口上使用 Lambda 表达式。函数式接口就是只定义一个抽象方法的接口。
 *     哪怕接口有很多默认方法，只要接口只定义了一个抽象方法，它就仍然是一个函数式接口。
 *     比如 Comparator 和 Runnable。
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class Lambda2 {

    public static void main(String[] args) {
        /*
        * Lambda 表达式允许你直接以内联的形式为函数式接口的抽象方法提供实现，
        * 并把整个表达式作为函数式接口的实例（具体说来，是函数式接口一个具体实现的实例）
        * 用匿名内部类也可以完成同样的事情，只不过比较笨拙：需要提供一个实现，然后再直接内联将它实例化。
        */
        Runnable r1 = () -> System.out.println("Hello");// 使用 Lambda

        Runnable r2 = new Runnable() { // 使用匿名类

            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        processRunnable(r1);
        processRunnable(r2);

        processRunnable(() -> System.out.println("new Hello"));
    }

    /**
     * 接受函数式接口作为参数的方法都可以接受 Lambda 表达式作为参数
     */
    private static void processRunnable(Runnable runnable) {
        runnable.run();
    }

    /**
     * 新的 Java API 函数式接口都带有 @FunctionalInterface 的标注，这个标注用于表示该接口会设计成一个函数式接口。
     * 如果你用 @FunctionalInterface 定义了一个接口，而它却不是函数式接口的话，编译器将返回一个提示原因的错误。
     * 请注意，@FunctionalInterface 不是必需的，但对于为此设计的接口而言，使用它是比较好的做法。它就像是 @Override 标注表示方法被重写了。
     */
    @FunctionalInterface
    public interface Processor {

        /**
         * 函数式接口的抽象方法的签名基本上就是 Lambda 表达式的签名，这种抽象方法叫作函数描述符。
         * 例如，Runnable 接口可以看作一个什么也不接受什么也不返回（void）的函数的签名，
         * 因为它只有一个叫作 run 的抽象方法，这个方法什么也不接受，什么也不返回（void）。
         */
        void process(String content);
    }
}
