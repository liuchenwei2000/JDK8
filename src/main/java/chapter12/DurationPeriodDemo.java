package chapter12;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Duration、Period 示例
 * <p>
 *     Duration、Period 用于表示两个 Temporal 对象之间的时间段。
 *     如果需要以年、月或者日的方式对多个时间单位表示时间段，可以使用 Period 类。
 * <p>
 * Created by liuchenwei on 2019-04-29.
 */
public class DurationPeriodDemo {

    public static void main(String[] args) {
        // Duration 类的静态工厂方法 between 可以创建两个 LocalTimes 对象、
        // 两个 LocalDateTimes 对象，或者两个 Instant 对象之间的 duration。
        Duration d1 = Duration.between(LocalTime.of(6, 30, 0), LocalTime.now());
        System.out.println(d1);
        System.out.println(d1.getSeconds());
        Duration d2 = Duration.between(LocalDateTime.of(2019, 4, 19, 10, 0, 0), LocalDateTime.now());
        System.out.println(d2);
        Duration d3 = Duration.between(Instant.ofEpochSecond(1), Instant.now());
        System.out.println(d3);

        Period p1 = Period.between(LocalDate.of(2014, 3, 8), LocalDate.now());
        System.out.println(p1);

        // Duration 和 Period 类都提供了很多非常方便的工厂类，直接创建对应的实例
        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
    }
}
