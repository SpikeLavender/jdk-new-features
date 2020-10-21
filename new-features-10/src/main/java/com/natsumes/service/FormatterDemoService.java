package com.natsumes.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author hetengjiao
 */
public class FormatterDemoService {
    public static void main(String[] args) throws Exception{
        formatterDemoMethod();
    }

    private static void formatterDemoMethod() throws FileNotFoundException {
        var scan = new Scanner(new FileInputStream(new File("c:/Users/cmcc/aa.txt")), "utf-8");
        scan.useDelimiter(" |,");
        while (scan.hasNext()) {
            System.out.println(scan.next());
        }
    }
}
