package com.natsumes.service;

/**
 * @author hetengjiao
 * @param <T>
 */
public interface ITeacherService<T> {

    // java 7 以及以前版本特性: 全局变量和抽象方法
    public static final String a = "22";

    boolean process(T t);

    // java 8 特性: 静态方法和默认方法
    default void love() {
        System.out.println("java 8 特性: 默认方法");
    }

    static void hello() {
        System.out.println("java 8 特性: 静态方法");
    }

    // java 9 特性: 支持私有方法
    private void java9() {
        System.out.println("java  9 特性: 私有方法");
    }
}
