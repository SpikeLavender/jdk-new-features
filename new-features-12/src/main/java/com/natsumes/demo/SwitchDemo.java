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
        switchValueBeforeV12(day);
        switchValueInV12(day);
        howMany(2);
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
     * JDK12之前, 许多Switch表达式，每个case都会赋值给一个变量或者执行某种操作，如下是赋值给num变量具体值
     * 此表达是迂回的，重复的，并且容易出错
     *
     * @param day day
     */
    private static void switchValueBeforeV12(DayOfWeek day) {
        int num;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                num = 6;
                break;
            case THURSDAY:
                num = 7;
                break;
            case TUESDAY:
            case SATURDAY:
                num = 8;
                break;
            case WEDNESDAY:
                num = 9;
                break;
            default:
                throw new IllegalStateException("Error: " + day);
        }
        System.out.println("before jdk 12, num = " + num);
    }

    /**
     * JDK12: 使用更清晰，更安全Switch表达式
     * @since 12
     * @param day day
     */
    private static void switchValueInV12(DayOfWeek day) {
        int num = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case SATURDAY, THURSDAY -> 8;
            case WEDNESDAY -> 9;
        };
        System.out.println("in jdk 12, num = " + num);
    }

    /**
     * 用在方法上
     * @since 12
     * @param k k
     */
    private static void howMany(int k) {
        switch (k) {
            case 1 -> System.out.println("one");
            case 2 -> System.out.println("two");
            case 3 -> System.out.println("three");
        }
    }
}
