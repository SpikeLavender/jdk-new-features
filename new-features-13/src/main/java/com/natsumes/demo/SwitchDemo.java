package com.natsumes.demo;

import java.time.DayOfWeek;

import static java.time.DayOfWeek.FRIDAY;

/**
 * @author hetengjiao
 */
public class SwitchDemo {
    public static void main(String[] args) {
        DayOfWeek day = FRIDAY;
        switchBeforeV12(day);
        switchInV12(day);
        switchInV13(2);
    }

    /**
     * JDK12之前的版本
     *
     * @param day day
     */
    private static void switchBeforeV12(DayOfWeek day) {
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                break;
            case TUESDAY:
                System.out.println(7);
                break;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                break;
            case WEDNESDAY:
                System.out.println(9);
                break;
        }
    }

    /**
     * JDK 12 版本
     * 引入一种新形式的开关标签，写成“case L ->”表示如果标签匹配，则只执行标签右侧的代码。
     *
     * @since 12
     * @param day day
     */
    private static void switchInV12(DayOfWeek day) {
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY -> System.out.println(7);
            case THURSDAY, SATURDAY -> System.out.println(8);
            case WEDNESDAY -> System.out.println(9);
        }
    }

    /**
     * JDK 13 版本
     * 可以返回信息
     *
     * @since 13
     */
    private static void switchInV13(int k) {
        String result = switch (k) {
            case 1 -> "one";
            case 2 -> "two";
            default -> "many";
        };

        System.out.println(result);
    }
}
