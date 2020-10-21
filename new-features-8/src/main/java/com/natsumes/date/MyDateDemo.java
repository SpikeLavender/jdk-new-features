package com.natsumes.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author hetengjiao
 */
public class MyDateDemo {

    Instant instant = Instant.now();    //获取当前时间戳

    LocalDate localDate = LocalDate.now();  //获取当前日期

    LocalTime localTime = LocalTime.now();  //获取当前时刻

    LocalDateTime localDateTime = LocalDateTime.now();  //获取当前具体时间

    ZonedDateTime zonedDateTime = ZonedDateTime.now();  //获取带有时区的时间

    public static void main(String[] args) {
        MyDateDemo myDateDemo = new MyDateDemo();
        String str = "2020-10-11";
        myDateDemo.date2String(str);
        myDateDemo.date2LocalDate();
        myDateDemo.localDate2Date();
        myDateDemo.timestamp2LocalDateTime();
        myDateDemo.localDateTime2Timestamp();
    }

    /**
     * 字符串转换
     * @since 1.7
     *      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
     *      try {
     *          Date date = simpleDateFormat.parse(str);
     *      } catch (ParseException e){
     *          e.printStackTrace();
     *      }
     *
     * @since 1.8
     */
    private void date2String(String str) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(str, formatter);
        System.out.println(localDate);
    }

    /**
     * Date转换LocalDate
     */
    private void date2LocalDate() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println("Date = " + date);
        System.out.println("LocalDate = " + localDate);
    }

    /**
     * LocalDate转换Date
     */
    private void localDate2Date() {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);

        Date date = Date.from(zdt.toInstant());

        System.out.println("LocalDate = " + localDate);
        System.out.println("Date = " + date);
    }

    /**
     * 时间戳转LocalDateTime
     */
    private void timestamp2LocalDateTime() {
        long timestamp = System.currentTimeMillis();
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("timestamp = " + timestamp);
        System.out.println("localDateTime = " + localDateTime);
    }

    /**
     * LocalDateTime转时间戳
     */
    private void localDateTime2Timestamp() {
        LocalDateTime localDateTime = LocalDateTime.now();
        long timestamp = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("timestamp = " + timestamp);

        timestamp = localDateTime.toInstant(ZoneOffset.of("+08:00")).toEpochMilli();
        System.out.println("timestamp = " + timestamp);

        timestamp = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println("timestamp = " + timestamp);
    }

    /**
     * LocalDate方法总结
     */
    private void localDateApi() {
        LocalDate date = LocalDate.now();

        int year = date.getYear(); // 获取当前日期的年份

        Month month = date.getMonth();  // 获取当前日期的月份对象

        int monthValue = date.getMonthValue();  // 获取当前日期是第几月

        DayOfWeek dayOfWeek = date.getDayOfWeek();  // 表示该对象表示的日期是星期几

        int dayOfMonth = date.getDayOfMonth();  // 表示该对象表示的日期是这个月第几天

        int dayOfYear = date.getDayOfYear();    // 表示该对象表示的日期是今年第几天

        LocalDate withYear = date.withYear(2020);   // 修改当前对象的年份

        LocalDate withMonth = date.withMonth(10);   // 修改当前对象的月份

        LocalDate withDayOfMonth = date.withDayOfMonth(10); // 修改当前对象在当月的日期

        boolean isLeapYear = date.isLeapYear();     // 是否是闰年

        int lengthOfMonth = date.lengthOfMonth();   // 这个月有多少天

        int lengthOfYear = date.lengthOfYear();    // 该对象表示的年份有多少天（365或者366）

        LocalDate plusYears = date.plusYears(10);   // 当前对象增加指定的年份数

        LocalDate plusMonths = date.plusMonths(1);  // 当前对象增加指定的月份数

        LocalDate plusWeeks = date.plusWeeks(1);    // 当前对象增加指定的周数

        LocalDate plusDays = date.plusDays(10);     // 当前对象增加指定的天数

        LocalDate minusYears = date.minusYears(1);//当前对象减去指定的年数

        LocalDate minusMonths = date.minusMonths(1);// 当前对象减去注定的月数

        LocalDate minusWeeks = date.minusWeeks(1);// 当前对象减去指定的周数

        LocalDate minusDays = date.minusDays(10);// 当前对象减去指定的天数

        LocalDate other = LocalDate.now();

        int i = date.compareTo(other);  // 比较当前对象和other对象在时间上的大小，返回值如果为正，则当前对象时间较晚

        boolean before = date.isBefore(other);  //比较当前对象日期是否在other对象日期之前

        boolean after = date.isAfter(other);    //比较当前对象日期是否在other对象日期之后

        boolean equal = date.isEqual(other);    // 比较两个日期对象是否相等
    }
}
