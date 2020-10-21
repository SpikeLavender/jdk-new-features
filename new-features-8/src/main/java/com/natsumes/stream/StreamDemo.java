package com.natsumes.stream;

import com.natsumes.lambda.dto.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hetengjiao
 */
public class StreamDemo {

    private static List<Student> students = Arrays.asList(
            new Student("张三", "man", 5000, 18, "天秤座"),
            new Student("李四", "man", 1000, 16, "巨蟹座"),
            new Student("王五", "female", 2000, 20, "白羊座")
    );

    private static List<Student> students4Collect = Arrays.asList(
            new Student("张三", "man", 5000, 18, "天秤座"),
            new Student("李四", "man", 1000, 16, "巨蟹座"),
            new Student("王五", "female", 2000, 20, "白羊座"),
            new Student("董六", "female", 7000, 20, "白羊座")
    );

    private static List<String> strs = Arrays.asList(
            "aaa bbb ccc",
            "ddd eee fff",
            "ggg hhh iii"
    );

    public static void main(String[] args) {
        // 1.stream
        // 将集合转换成流,一般会使用流继续后续操作
        Stream<Student> stream = students.stream();
        System.out.println(stream);
        // 2.forEach遍历
        // forEach遍历集合，System.out::println等同于System.out.println()
        students.forEach(System.out::println);

        // 3.filter过滤
        // 该方法中是一个筛选条件，等同于sql查询的where后面的筛选
        students.stream().filter(e -> "天秤座".equals(e.getStar())).forEach(System.out::println);

        // 4.map转换集合
        // 将List<Student> 转换为List<String>, collect是将结果转换为List
        List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());
        names.forEach(System.out::println);

        // 5.mapToInt转换数值流
        // 转换数值流，等同mapToLong、mapToDouble，如下这个是取最大值
        IntStream intStream = students.stream().mapToInt(Student::getAge);
        Stream<Integer> integerStream = intStream.boxed();
        Optional<Integer> max = integerStream.max(Integer::compareTo);
        System.out.println(max.orElse(null));

        // 6.flatMap合并成一个流
        // 将流中的每一个元素 T 映射为一个流，再把每一个流连接成为一个流
        List<String> strings = strs.stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(strings);

        // 7.distinct去重
        List<String> strs2 = Arrays.asList(
                "aaa bbb ccc",
                "ddd eee fff",
                "ggg hhh iii",
                "ggg hhh iii"
        );
        strs2.stream().distinct().forEach(System.out::println);

        // 8.sorted排序
        // asc排序
        students.stream().sorted(Comparator.comparingInt(Student::getAge)).forEach(System.out::println);
        // desc排序
        students.stream().sorted(Comparator.comparingInt(Student::getAge).reversed()).forEach(System.out::println);

        // 9.skip跳过前n个
        students.stream().skip(1).forEach(System.out::println);

        // 10.limit截取前n个
        students.stream().limit(1).forEach(System.out::println);

        // 11.anyMatch
        // 只要有其中任意一个符合条件
        boolean isAnyMatch = students.stream().anyMatch(student -> student.getAge() == 16);
        System.out.println(isAnyMatch);

        // 12.allMatch
        // 全部符合
        boolean isAllMatch = students.stream().allMatch(student -> student.getAge() == 16);
        System.out.println(isAllMatch);

        // 13.noneMatch
        // 是否满足没有符合的
        boolean isNoneMatch = students.stream().noneMatch(student -> student.getAge() == 16);
        System.out.println(isNoneMatch);

        // 14.findAny
        // 找到其中一个元素 （使用 stream() 时找到的是第一个元素；使用 parallelStream() 并行时找到的是其中一个元素）
        Optional<Student> streamAny = students.stream().findAny();
        System.out.println(streamAny.orElse(null));

        // 15.findFirst
        // 找到第一个元素
        Optional<Student> streamFirst = students.stream().findFirst();
        System.out.println(streamFirst.orElse(null));

        // 16.count计数
        long count = students.stream().count();
        System.out.println(count);

        // 17.of
        // 生成一个字符串流
        Stream<String> stringStream = Stream.of("i", "love", "you");
        System.out.println(stringStream);

        // 18.empty
        // 生成一个空流
        Stream<Object> empty = Stream.empty();
        System.out.println(empty);

        // 19.iterate
        List<String> list = Arrays.asList("a", "b", "c", "c", "d", "f", "a");
        Stream.iterate(0, i -> i + 1)
                .limit(list.size())
                .forEach(i -> System.out.println(i +list.get(i)));

        // 20.collect：averagingLong
        // 求平均值
        Double aDouble = students4Collect.stream().collect(Collectors.averagingLong(Student::getAge));
        System.out.println("avg = " + aDouble);

        // 21.collect：collectingAndThen
        // 两步结束，先如何，在如何
        String avg = students4Collect.stream().collect(Collectors
                .collectingAndThen(Collectors.averagingInt(Student::getAge), a -> "avg age = " + a));
        System.out.println(avg);

        // 22.collect：counting
        // 求个数
        Long num = students4Collect.stream().collect(Collectors.counting()); // can be replaced as stream.count()
        System.out.println(num);

        // 23.collect: groupingBy(Function)
        Map<Integer, List<Student>> agesMap = students4Collect.stream().collect(Collectors.groupingBy(Student::getAge));
        for (Integer age : agesMap.keySet()) {
            System.out.println(agesMap.get(age));
        }

        // 24.collect：groupingBy(Function,Collector)
        // 先分组，然后计算每组的个数
        Map<Integer, Long> numMap = students4Collect.stream()
                .collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));
        System.out.println(numMap);

        // 25.collect：groupingBy(Function, Supplier, Collector)
        // 先分组，然后计算每组的个数,然后排序
        TreeMap<Integer, Long> treeNumMap = students4Collect.stream()
                .collect(Collectors.groupingBy(Student::getAge, TreeMap::new, Collectors.counting()));
        System.out.println(treeNumMap);

        // 26.collect：groupingByConcurrent
        // 同上，不过这个Concurrent是并发的，也有3个方法，和上面非并发一个效果
        // groupingByConcurrent(Function)
        // groupingByConcurrent(Function, Collector)
        // groupingByConcurrent(Function, Supplier, Collector)

        // 27.collect：joining()
        // 拼接
        String name = students4Collect.stream().map(Student::getName).collect(Collectors.joining());
        System.out.println(name);

        // 28.collect：joining(str)
        // 拼接, 用逗号隔开
        String nameByComma = students4Collect.stream()
                .map(Student::getName)
                .collect(Collectors.joining(","));
        System.out.println(nameByComma);

        // 29.collect：joining(str, prefix, suffix)
        // 拼接, 包含前缀、后缀
        String nameWithPrefixAndSuffix = students4Collect.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",", "hello", "world"));
        System.out.println(nameWithPrefixAndSuffix);
        // 30.collect：summarizingDouble
        // 求年龄的最大值、最小值、平均值、综合以及人数
        DoubleSummaryStatistics statistics = students4Collect.stream()
                .collect(Collectors.summarizingDouble(Student::getAge));
        System.out.println(statistics);

        // 31.collect：toCollection
        // Collectors.toList()
        // Collectors.toCollection()
        // Collectors.toConcurrentMap();
        // Collectors.toMap();
        // Collectors.toSet();
        Map<String, String> stringMap = students4Collect.stream()
                .collect(Collectors.toMap(Student::getName, Student::getStar));
        System.out.println(stringMap);

    }
}
