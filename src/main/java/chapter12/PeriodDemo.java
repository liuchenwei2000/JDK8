package chapter12;

import java.time.*;

/**
 * Period 示例
 * <p>
 *     如果需要以年、月或者日的方式对多个时间单位表示时间段，可以使用 Period 类。
 * <p>
 * Created by liuchenwei on 2019-04-29.
 */
public class PeriodDemo {

    public static void main(String[] args) {
        // Duration 类的静态工厂方法 between 可以创建两个 LocalTimes 对象、
        // 两个 LocalDateTimes 对象，或者两个 Instant 对象之间的 duration。
        Period p1 = Period.between(LocalDate.of(2014, 3, 8), LocalDate.now());
        System.out.println(p1);

        // Duration和Period类都提供了很多非常方便的工厂类，直接创建对应的实例
    }
}
