package com.bosssoft.hr.train.j2se.basic.example.collection;

/**
 * @description: 对Map的主要方法做测试
 * @author: Administrator
 * @create: 2020-05-28 20:45
 * @since
 **/
public interface MapExample<T,V> {
    /**
     *
     * @param key  map的键
     * @param value 值
     * @return 返回值
     */
     V put(T key,V value);
    /**
     *
     * @param key  map的键
     * @return 返回值
     */
     V remove(T key);

    /**
     *
     * @param key  map的键
     * @return 返回值 是否存在的判断
     */
     boolean containsKey(T key);

    /**
     * 迭代方式1
     */
    void visitByEntryset();
    /**
     * 迭代方式2
     */
     void visitByKeyset();
    /**
     * 迭代方式3
     */
     void visitByValues();

}
