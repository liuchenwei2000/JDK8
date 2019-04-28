package chapter9;

/**
 * 接口的一个实现类
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-28.
 */
public class Bird implements Flyable {

    /**
     * 也可以实现接口中的默认方法
     */
    @Override
    public void fly() {
        System.out.println("I'm a bird");
        Flyable.flyImpl();// 也可以调用接口中的静态方法
    }

    public static void main(String[] args) {
        Flyable flyable = new Bird();
        flyable.fly();
    }
}
