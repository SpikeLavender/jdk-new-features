package com.natsumes.lambda.service;

import com.natsumes.lambda.dto.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * lambda主要是针对集合中条件的筛选，包括数组等等
 * 演变过程：
 *      普通筛选 -> 匿名内部类 -> 半lambda方法 -> lambda方法
 */
public class MyService {

    private List<Student> students = Arrays.asList(
            new Student("张三", "man", 5000, 18, "天秤座"),
            new Student("李四", "man", 1000, 18, "巨蟹座"),
            new Student("王五", "female", 2000, 18, "白羊座")
    );

    public static void main(String[] args) {
        MyService myService = new MyService();
        myService.test1();
        System.out.println("===============================");
        myService.test2();
        System.out.println("===============================");
        myService.test3();
        System.out.println("===============================");
        myService.test4();
    }

    /**
     * 1.普通筛选
     * 将这个集合遍历，然后依次的判断，这是最为普通的一种方式。
     */
    private void test1() {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if ("天秤座".equals(student.getStar())) {
                result.add(student);
            }
        }

        System.out.println(result);
    }

    /**
     * 2.匿名内部类筛选
     * 2.3 通过匿名内部类和该方法得到结果
     */
    private void test2() {

        List<Student> results = filterStudent(students, new FilterProcess<Student>() {
            @Override
            public boolean process(Student student) {
                return "天秤座".equals(student.getStar());
            }
        });

        for (Student result : results) {

            System.out.println(result);
        }

    }

    /**
     * 2.2 通过一个公共函数，对集合以及筛选条件做一个共同方法，筛选到班级里星座是天秤星座的学生
     */
    private List<Student> filterStudent(List<Student> students, FilterProcess<Student> mp) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (mp.process(student)) {
                result.add(student);
            }
        }
        return result;
    }

    /**
     * 3.半Lambda方法
     * 通过Lambda直接判断，一步到位，不需要在写其他的方法
     */
    private void test3() {
        List<Student> results = filterStudent(this.students, (e) -> "天秤座".equals(e.getStar()));
        System.out.println(results);
    }

    /**
     * 4.真正运用lambda方法
     * 通过Lambda直接判断，一步到位，不需要在写其他的方法
     */
    private void test4() {
        students.stream()
                .filter((e) -> "天秤座".equals(e.getStar()))
                .forEach(System.out::println);
    }

}
