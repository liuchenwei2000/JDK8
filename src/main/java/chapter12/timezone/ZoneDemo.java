package chapter12.timezone;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TimeZone;

/**
 * Zone 示例
 * <p>
 *     时区的处理是新版日期和时间 API 新增加的重要功能，使用新版日期和时间 API 时区的处理被极大地简化了。
 *     新的 java.time.ZoneId 类是老版 java.util.TimeZone 的替代品。
 *     它的设计目标就是要让你无需为时区处理的复杂和繁琐而操心。
 *     跟其他日期和时间类一样，ZoneId类也是无法修改的。
 * <p>
 * Created by liuchenwei on 2019-04-29.
 */
public class ZoneDemo {

    public static void main(String[] args) {
        // 时区是按照一定的规则将区域划分成的标准时间相同的区间。
        // 在 ZoneRules 这个类中包含了 40 个这样的实例。
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
        // 新方法 toZoneId 将一个老的时区对象转换为 ZoneId
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println("Default zone is " + zoneId);
        // 一旦得到一个 ZoneId 对象，就可以将它与 LocalDate、LocalDateTime 或者是 Instant 对象整合起来，
        // 构造为一个ZonedDateTime实例，它代表了相对于指定时区的时间点。
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(zoneId);
        System.out.println(zdt2);
    }
}
