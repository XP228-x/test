package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

public interface StackExmaple<T> {
    /**
     * 添加到队尾
     * @param node
     * @return
     */
    User push(T node);

    /**
     * 从队头删除
     * @return
     */
    T pop();

    /**
     * 查看队头元素
     */
    T peek();

    /**
     * 判断栈是否为空
     */
    boolean empty();
}
