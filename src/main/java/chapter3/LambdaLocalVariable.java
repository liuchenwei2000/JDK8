package chapter3;

/**
 * Lambda 使用局部变量
 * <p>
 *     Lambda 表达式也允许使用局部变量（不是参数，而是在外层作用域中定义的变量），就像匿名类一样。
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class LambdaLocalVariable {

    public static void main(String[] args) {
        int portNumber = 1337;
        // 下面的 Lambda 捕获了 portNumber 变量
        Runnable r = () -> System.out.println(portNumber);
        // Lambda 可以没有限制地捕获（也就是在其主体中引用）实例变量和静态变量。
        // 但局部变量必须显式声明为 final，或事实上是 final。
        // 换句话说，Lambda 表达式只能捕获指派给它们的局部变量一次。（注：捕获实例变量可以被看作捕获最终局部变量this。）
        // 例如，下面的代码无法编译，因为 portNumber2 变量被赋值两次：
//        int portNumber2 = 1337;
//        Runnable r2 = () -> System.out.println(portNumber2);
//        portNumber2 = 31337;

        /*
        * 为什么局部变量有这些限制？
        * 实例变量和局部变量背后的实现有一个关键不同。实例变量都存储在堆中，而局部变量则保存在栈上。
        * 如果Lambda可以直接访问局部变量，而且Lambda是在一个线程中使用的，
        * 则使用Lambda的线程可能会在分配该变量的线程将这个变量收回之后，去访问该变量。
        * 因此，Java在访问局部变量时，实际上是在访问它的副本，而不是访问原始变量。
        * 如果局部变量仅仅赋值一次那就没有什么区别了——因此就有了这个限制。
        */
    }
}
