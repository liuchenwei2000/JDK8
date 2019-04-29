package chapter12.operation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * 格式化日期示例
 * <p>
 *     处理日期和时间对象时，格式化以及解析日期-时间对象是另一个非常重要的功能。
 *     新的 java.time.format 包就是特别为这个目的而设计的。
 *     这个包中，最重要的类是 DateTimeFormatter。创建格式器最简单的方法是通过它的静态工厂方法以及常量。
 *     像 BASIC_ISO_DATE 和 ISO_LOCAL_DATE 这样的常量是 DateTimeFormatter 类的预定义实例。
 *     所有的 DateTimeFormatter 实例都能用于以一定的格式创建代表特定日期或时间的字符串。
 * <p>
 * Created by liuchenwei on 2019-04-29.
 */
public class FormatterDemo {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(s1);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s2);

        // 也可以通过解析代表日期或时间的字符串重新创建该日期对象。
        // 所有的日期和时间 API 都提供了表示时间点或者时间段的工厂方法 parse。
        LocalDate date1 = LocalDate.parse("20190318", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date1);
        LocalDate date2 = LocalDate.parse("2019-03-18", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(date2);

        /*
        * 和老的 java.util.DateFormat 相比较，所有的 DateTimeFormatter 实例都是线程安全的。
        * 所以，你能够以单例模式创建格式器实例，就像 DateTimeFormatter 所定义的那些常量，并能在多个线程间共享这些实例。
        * DateTimeFormatter 类还支持一个静态工厂方法，它可以按照某个特定的模式创建格式器。
        */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = LocalDate.now().format(formatter);
        System.out.println(formattedDate);
        LocalDate date3 = LocalDate.parse("30/03/2019", formatter);
        System.out.println(date3);
    }
}
