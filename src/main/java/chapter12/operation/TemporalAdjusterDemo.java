package chapter12.operation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * TemporalAdjuster 示例
 * <p>
 *     有时候需要进行一些更加复杂的操作，比如，将日期调整到下个周日或者是本月的最后一天。
 *     这时，可以使用重载版本的 with 方法，向其传递一个提供了更多定制化选择的
 *     TemporalAdjuster 对象，更加灵活地处理日期。
 *     对于最常见的用例，日期和时间 API 已经提供了大量预定义的 TemporalAdjuster。
 *     可以通过 TemporalAdjuster 类的静态工厂方法访问它们
 * <p>
 * Created by liuchenwei on 2019-04-29.
 */
public class TemporalAdjusterDemo {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        System.out.println(date1);
        LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println(date2);
        LocalDate date3 = date2.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(date3);
        /*
        * 即使没有找到符合要求的预定义的 TemporalAdjuster，创建自己的 TemporalAdjuster 也并非难事。
        * 实际上，TemporalAdjuster 接口只声明了单一的一个方法（这使得它成为了一个函数式接口）
        */
    }
}
