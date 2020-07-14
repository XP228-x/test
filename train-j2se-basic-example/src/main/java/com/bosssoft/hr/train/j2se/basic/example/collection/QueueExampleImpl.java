package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class QueueExampleImpl implements QueueExmaple<User>{
    private List<User> users = new ArrayList<User>();
    /**
     * 添加到队尾
     * @param node
     */
    @Override
    public boolean push(User node){
        return users.add(node);
    }

    /**
     * 从队头删除
     * @return
     */
    @Override
    public User pop(){
        return users.remove(0);
    }

    /**
     * 查看队头元素
     */
    @Override
    public User peek(){
        return users.get(users.size()-1);
    }

    /**
     * 判断栈是否为空
     */
    @Override
    public boolean empty(){
        return users.isEmpty();
    }
}
