package com.natsumes.service;

import java.io.*;

/**
 * @author hetengjiao
 */
public class ReaderDemoService {

    public static void main(String[] args) throws IOException{
        readerDemo();
    }

    private static void readerDemo() throws IOException {
        var reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("c:/Users/cmcc/aa.txt"), "utf-8"));
        var p = new PrintWriter(new File("c:/Users/cmcc/bb.txt"));

        reader.transferTo(p);
        p.flush();
        p.close();
        reader.close();
    }
}
