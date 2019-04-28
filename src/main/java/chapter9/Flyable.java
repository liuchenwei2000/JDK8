package chapter9;

/**
 * 拥有默认方法的一个接口
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-28.
 */
public interface Flyable {

    /**
     * 这是一个默认方法
     * <p>
     *     默认方法由 default 修饰符修饰，并像类中声明的其他方法一样包含方法体。
     *     这样任何一个实现了 Flyable 接口的类都会自动继承 fly 的实现。
     */
    default void fly() {
        flyImpl();
    }

    /**
     * 这是一个接口内的静态方法
     */
    static void flyImpl() {
        System.out.println("I can fly");
    }
}
