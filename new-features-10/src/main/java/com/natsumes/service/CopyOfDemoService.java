package com.natsumes.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hetengjiao
 */
public class CopyOfDemoService {

    public static void main(String[] args) {

        var list = new ArrayList<>();

        list.add("first");
        list.add("second");
        list.add("third");

        var result = List.copyOf(list);

        System.out.println("list = " + list);
        System.out.println("result = " + result);

        list.remove(1);
        System.out.println("list = " + list);

        result.remove(2);   //throw UnsupportedOperationException
    }
}
