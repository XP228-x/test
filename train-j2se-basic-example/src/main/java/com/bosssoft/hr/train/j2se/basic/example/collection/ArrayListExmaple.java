package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

/**
 *  ArrayList优势在随机访问和尾部添加 劣势中间插入
 */
public interface ArrayListExmaple<T> extends ListExample<T> {

    /**
     *
     * @param position
     * @param node
     * @return
     */
     boolean insert(Integer position,T node);

    /**
     * 中间删除
     * @param position
     * @return
     */
     boolean remove(Integer position);


}
