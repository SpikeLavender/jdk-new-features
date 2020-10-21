package com.natsumes.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author hetengjiao
 */
public class BAOStreamDemoService {

    public static void main(String[] args) throws Exception {
        defaultBis();
        gbkBis();
        gbkBos();
    }

    private static void defaultBis() throws Exception {
        String str = "I love java";
        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("utf-8"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int c;

        while ((c = bis.read()) != -1) {
            bos.write(c);
        }
        //bos.toString() 默认的使用的UTF-8编码
        System.out.println(bos.toString());
    }

    private static void gbkBis() throws Exception {
        String str = "I love java";
        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("gbk"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int c;

        while ((c = bis.read()) != -1) {
            bos.write(c);
        }
        //bos.toString() 默认的使用的UTF-8编码
        System.out.println(bos.toString());
    }

    private static void gbkBos() throws Exception {
        String str = "I love java";
        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("gbk"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int c;

        while ((c = bis.read()) != -1) {
            bos.write(c);
        }
        //bos.toString() 默认的使用的UTF-8编码
        System.out.println(bos.toString("gbk"));
    }

}
