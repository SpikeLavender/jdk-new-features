package com.natsumes.service;

import java.io.PrintWriter;

/**
 * @author hetengjiao
 */
public class NewDemoService {

    public static void main(String[] args) throws Exception {
        printStreamMethod();
    }

    private static void printStreamMethod() throws Exception{
        String str = "I love java";
        var pri = new PrintWriter("c:/Users/cmcc/aa.txt", "utf-8"); // default utf-8
        pri.println(str);
        pri.flush();
        pri.close();
    }
}
