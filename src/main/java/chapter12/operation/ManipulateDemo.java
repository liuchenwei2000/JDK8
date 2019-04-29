package chapter12.operation;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * 操纵日期示例
 * <p>
 *     如果已经有一个 LocalDate 对象，想要创建它的一个修改版，
 *     最直接也最简单的方法是使用 withAttribute 方法。
 *     withAttribute 方法会创建对象的一个副本，并按照需要修改它的属性。
 * <p>
 * Created by liuchenwei on 2019-04-29.
 */
public class ManipulateDemo {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        System.out.println(date1);
        LocalDate date2 = date1.withYear(2011);
        System.out.println(date2);
        LocalDate date3 = date2.withDayOfMonth(25);
        System.out.println(date3);
        // 采用更通用的 with 方法能达到同样的目的，它接受的第一个参数是一个 TemporalField 对象
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println(date4);
        /*
        * with 方法和 get方法有些类似，它们都声明在 Temporal 接口，
        * 所有的日期和时间 API 类都实现这两个方法，它们定义了单点的时间，
        * 比如 LocalDate、LocalTime、LocalDateTime 以及 Instant。
        * 更确切地说，使用 get 和 with 方法，可以将 Temporal 对象值的读取和修改区分开。
        */

        // 也可以以声明的方式操纵 LocalDate 对象。比如像下面这段代码那样加上或者减去一段时间。
        // 通过这些方法，对 TemporalUnit 对象加上或者减去一个数字，能非常方便地将其前溯或者回滚至某个时间段
        LocalDate date5 = date1.plusWeeks(1);
        System.out.println(date5);
        LocalDate date6 = date2.minusYears(3);
        System.out.println(date6);
        LocalDate date7 = date3.plus(6, ChronoUnit.MONTHS);
        System.out.println(date7);
    }
}
