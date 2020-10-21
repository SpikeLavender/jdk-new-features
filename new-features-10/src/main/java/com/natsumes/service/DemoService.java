package com.natsumes.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author hetengjiao
 */
public class DemoService {

    public static void main(String[] args) {

        var number = 10;

        var str = "i like java";

        var list = new ArrayList<>();

        var map = new HashMap<>();

        var set = new HashSet<>();

        list.add("test var is list");

        map.put("1", "test var is map");

        set.add("test var is set");

        System.out.println(number);

        System.out.println(str);

        System.out.println(list);

        System.out.println(map);

        System.out.println(set);
    }
}
