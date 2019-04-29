package chapter12;

import java.time.Instant;

/**
 * Instant 示例
 * <p>
 *     作为人，我们习惯于以星期几、几号、几点、几分这样的方式理解日期和时间。
 *     毫无疑问，这种方式对于计算机而言并不容易理解。从计算机的角度来看，
 *     建模时间最自然的格式是表示一个持续时间段上某个点的单一大整型数。
 *     这也是新的 java.time.Instant 类对时间建模的方式，基本上它是以 Unix 元年时间
 *     （传统的设定为 UTC 时区 1970 年 1 月 1 日午夜时分）开始所经历的秒数进行计算。
 * <p>
 * Created by liuchenwei on 2019-04-29.
 */
public class InstantDemo {

    public static void main(String[] args) {
        // 可以通过向静态工厂方法 ofEpochSecond 传递一个代表秒数的值创建一个该类的实例。
        Instant instant = Instant.ofEpochSecond(3);
        System.out.println(instant);
        Instant.ofEpochSecond(3, 0);
        Instant.ofEpochSecond(2, 1_000_000_000);
        Instant.ofEpochSecond(4, -1_000_000_000);

        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.getEpochSecond());
    }
}
