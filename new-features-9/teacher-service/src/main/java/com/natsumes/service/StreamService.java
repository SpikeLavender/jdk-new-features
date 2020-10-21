package com.natsumes.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author hetengjiao
 */
public class StreamService {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(45, 43, 76, 87, 98, 90, 73, 77, 53);

        // takeWhile 当达到一定条件就结束
        list.stream().takeWhile(x -> x < 50).forEach(System.out::println);

        System.out.println("===================================");

        // dropWhile 当达到一定条件就开始
        list.stream().dropWhile(x -> x < 50).forEach(System.out::println);

        // ofNullable, 在java8中 Stream中的元素不能完全为null，否则空指针异常，而在java9的升级中，允许创建null
        Stream<Object> stream = Stream.ofNullable(null);
        System.out.println(stream);

        // iterate 不加条件无线循环
        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println); // 原来的控制终止方式

        System.out.println("==========================");

        Stream.iterate(1, i -> i < 10, i -> i + 1).forEach(System.out::println); // java9的终止方式
    }
}
