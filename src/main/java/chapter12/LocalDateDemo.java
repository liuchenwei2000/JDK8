package chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * LocalDate 示例
 * <p>
 *     LocalDate 的实例是一个不可变对象，它只提供了简单的日期，并不含当天的时间信息。
 *     另外，它也不附带任何与时区相关的信息。
 * <p>
 * Created by liuchenwei on 2019-04-29.
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        // 可以通过静态工厂方法 of 创建一个 LocalDate 实例
        LocalDate date = LocalDate.of(2019, 3, 18);

        int year = date.getYear();
        System.out.println(year);

        Month month = date.getMonth();
        System.out.println(month);

        int dayOfMonth = date.getDayOfMonth();
        System.out.println(dayOfMonth);

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek);

        int lengthOfMonth = date.lengthOfMonth();
        System.out.println(lengthOfMonth);

        boolean leapYear = date.isLeapYear();
        System.out.println(leapYear);

        // 可以使用工厂方法从系统时钟中获取当前的日期
        LocalDate today = LocalDate.now();
        // 可以通过传递一个 TemporalField 参数给 get 方法拿到同样的信息。
        // TemporalField 是一个接口，它定义了如何访问 temporal 对象某个字段的值。
        // ChronoField 枚举实现了这一接口，所以可以很方便地使用get方法得到枚举元素的值。
        int yearc = today.get(ChronoField.YEAR);
        System.out.println(yearc);
        int monthc = today.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(monthc);
        int dayOfMonthc = today.get(ChronoField.DAY_OF_MONTH);
        System.out.println(dayOfMonthc);

        // 使用静态方法 parse 可以通过解析代表它们的字符串创建 LocalDate
        LocalDate date2 = LocalDate.parse("2019-11-23");
        System.out.println(date2);
    }
}
