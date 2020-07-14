package com.bosssoft.hr.train.j2se.basic.example.collection;

/**
 * 添加LinkedList 特有的测试方法
 * @param <T>
 */
public interface LinkedListExmaple<T> extends ListExample<T>{
    /**
     * 添加到链表头
     * @param node
     */
    void addFirst(T node);

    /**
     *  添加到链表尾
     * @param node
     */
    boolean offer(T node);
    /**
     * 设置同步访问防止多线程并发的安全问题
     */
    void sychronizedVisit(T node);


    /**
     *  ===============================>链表因为实现queue接口可以当做队列
     * @param node
     */
    void push(T node);

    /**
     * 出队
     * @return
     */
    T pop();
}
