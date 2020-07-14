package com.bosssoft.hr.train.j2se.basic.example.collection;


/**
 * @description: 哪里有Tree哪里就支持排序，SET操作具体参考 api 文档对其他方法演示
 * @author: Administrator
 * @create: 2020-05-28 20:45
 * @since
 **/
public interface TreeSetExmaple<T> {
    /**
     * 测试实现对数据排序
     * @param arry
     * @return 已经排序的数组
     */
    T[] sort(T[] arry);
}
