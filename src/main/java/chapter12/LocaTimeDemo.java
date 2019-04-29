package chapter12;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * LocaTime 示例
 * <p>
 *     LocaTime 和 LocaDate 类似，用来表示一天中的某个时刻。
 * <p>
 * Created by liuchenwei on 2019-04-29.
 */
public class LocaTimeDemo {

    public static void main(String[] args) {
        // 可以通过静态工厂方法 of 创建一个 LocaTime 实例
        LocalTime time = LocalTime.of(13, 23, 5);

        int hour = time.getHour();
        System.out.println(hour);

        int minute = time.getMinute();
        System.out.println(minute);

        int second = time.getSecond();
        System.out.println(second);

        // 可以使用工厂方法从系统时钟中获取当前的日期
        LocalTime now = LocalTime.now();
        int hourc = now.get(ChronoField.HOUR_OF_DAY);
        System.out.println(hourc);
        int minutec = now.get(ChronoField.MINUTE_OF_HOUR);
        System.out.println(minutec);
        int secondc = now.get(ChronoField.SECOND_OF_MINUTE);
        System.out.println(secondc);

        // 使用静态方法 parse 可以通过解析代表它们的字符串创建 LocalDate
        LocalTime time2 = LocalTime.parse("18:04:18");
        System.out.println(time2);
    }
}
