package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

import java.util.Stack;

public class StackExampleImpl implements StackExmaple<User>{
    public final static String LOG_TAG="j2se-basic-example-log:";
    /**=============================》StackExample
     * 演示的Stack对象
     */
    private Stack<User> users=new Stack<User>();
    /**
     *  这里开始 关于 Stack的主要方法测试
     * @param  node
     * @return
     */
    /**
     * 添加到栈顶
     * @param node
     * @return
     */
    @Override
    public User push(User node){
        return users.push(node);
    }

    /**
     * 从栈顶删除
     * @return
     */
    @Override
    public User pop(){
        return users.pop();
    }

    /**
     * 查看栈顶元素
     */
    @Override
    public User peek(){
        return users.peek();
    }

    /**
     * 判断栈是否为空
     */
    @Override
    public boolean empty(){
        return users.empty();
    }
}
