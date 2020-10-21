package com.natsumes.demo;

/**
 * @author hetengjiao
 */
public class NewApiDemo {

    public static void main(String[] args) {
        String str = "  I love java  ";

        boolean isBlank = str.isBlank();    // 判断字符串是空白, 包括 " "

        boolean isEmpty = str.isEmpty();    // 判断字符串是否为空

        String strip = str.strip();         // 去除首尾空白

        String stripTrailing = str.stripTrailing(); // 去除尾部空白

        String stripLeading = str.stripLeading();   // 去除首部空白

        String repeat = str.repeat(2);      // 复制几遍字符串

        long count = str.lines().count();   // 行数统计

        System.out.println(isBlank);
        System.out.println(isEmpty);
        System.out.println(strip + ".");
        System.out.println(stripTrailing + ".");
        System.out.println(stripLeading);
        System.out.println(repeat);
        System.out.println(count);
    }
}
