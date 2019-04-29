package chapter12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * LocalDateTime 示例
 * <p>
 *     LocalDateTime 是 LocalDate 和 LocalTime 的合体。
 *     它同时表示了日期和时间，但不带有时区信息，你可以直接创建，也可以通过合并日期和时间对象构造。
 * <p>
 * Created by liuchenwei on 2019-04-29.
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        // 直接创建
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        System.out.println(dt1);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        // 组合创建
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        System.out.println(dt2);
        // 其他组合创建方式
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        System.out.println(dt3);
        LocalDateTime dt4 = date.atTime(time);
        System.out.println(dt4);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt5);

        // 从 LocalDateTime 中提取 LocalDate 或者 LocalTime 组件
        LocalDate localDate = dt2.toLocalDate();
        LocalTime localTime = dt2.toLocalTime();
    }
}
