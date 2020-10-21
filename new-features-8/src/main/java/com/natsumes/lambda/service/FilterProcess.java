package com.natsumes.lambda.service;


/**
 * 2.1 通过匿名内部类的方法，在内部类中添加判断条件进行筛选,首先创建一个公共接口
 * @param <T>
 */
public interface FilterProcess<T> {

    boolean process(T t);

}
