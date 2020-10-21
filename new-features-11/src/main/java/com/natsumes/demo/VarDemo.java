package com.natsumes.demo;

import java.util.function.Consumer;

/**
 * @author hetengjiao
 */
public class VarDemo {

    public static void main(String[] args) {
        //String t = "i Love java";

        Consumer<String> consumer1 = t -> System.out.println(t.toUpperCase());

        Consumer<String> consumer2 = (var t) -> System.out.println(t.toUpperCase());

        // 错误的形式：必须要有类型，可以加上var
        //Consumer<String> consumer3 = (@Deprecated t) -> System.out.println(t.toUpperCase());

        // 正确的形式
        Consumer<String> consumer3 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }
}
