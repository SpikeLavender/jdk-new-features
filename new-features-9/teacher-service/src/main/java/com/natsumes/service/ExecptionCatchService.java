package com.natsumes.service;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hetengjiao
 */
public class ExecptionCatchService {

    /**
     * java7及以前写法  每一个流打开的时候都要关闭
     */
    public void javaBefore6() {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(System.in);
            int read = reader.read();
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
          if (reader != null) {
              try {
                  reader.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
        }
    }

    /**
     * java7和8 每一个流打开的时候都要关闭,但是在try的括号中来进行关闭
     */
    public void java7And8() {
        try(InputStreamReader reader = new InputStreamReader(System.in)) {
            int read = reader.read();
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * java9及 每一个流打开的时候都要关闭,但是在try的括号中来进行关闭，在ava8的基础上进一步升级，
     * 直接在try括号中直接写入 变量就好，如果有多个流，就用分号隔开
     * try(reader;writer){}
     */
    public void java9() {
        InputStreamReader reader = new InputStreamReader(System.in);
        try(reader) {
            int read = reader.read();
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
