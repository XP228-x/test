package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @description: 演示linkedList 的增删改查从操作
 * @author: Administrator
 * @create: 2020-05-22 14:40
 * @since
 **/

@Slf4j
public class LinkedListExampleImpl implements LinkedListExmaple<User> {
    public final static String LOG_TAG="j2se-basic-example-log:";
    /**=============================》ArrayListExample
     * 演示的arrayList对象
     */
    private LinkedList<User> users=new LinkedList<>();
    /**
     *  这里开始 关于 arraylist的主要方法测试
     * @param  node
     * @return
     */
    public boolean append(User node) {
        return users.add(node);
    }

    public User get(Integer index) {
        return index>=0 && index< users.size() ? users.get(index): null;
    }

    public boolean insert(Integer position, User user) {
      if (position>=0 && position<users.size()) {
          users.add(position,user);
          return true;
      }else
          return false;

    }

    public boolean remove(Integer position) {
        return position>=0 && position<users.size() ? users.remove(position.intValue())!=null
                : false;
    }

    public void listByIndex() {
        int size=users.size();
        for(int i=0;i<size;i++){
            log.info(LOG_TAG,users.get(i));
            /* 注意 如果在for遍历过程中作删除操作将导致异常 元素删除前移导致*/
            /** 以下代码被禁止
            if(users.get(i).getName().equalsIgnoreCase("jim")){
                users.remove(i);
            }
            */
        }
    }

    public void listByIterator() {
       Iterator<User> iterator= users.iterator();
       User user=null;
       for(;iterator.hasNext();user=iterator.next()){
           log.info(LOG_TAG,user);
       }

    }

    public User[] toArray() {
        return  users!=null ? users.toArray(new User[0]) :null;
    }

    /**
     * sonarlint 将会建议改进这种写法
     */
    public void sort() {

        /**
         *  这里 创建了一个匿名类实现了接口 Comparator
         *  也可以通过让 User 实现 Comparable接口实现但是这样做就污染了User类了
         */

        users.sort(new Comparator<User>() {
            public int compare(User o1, User o2) {
                return o1.getId()-o2.getId();
            }
        });
    }


    /**
     * 演示
     */
    public void sort2() {

        /**
         * what is lambda
         Syntax and Structure
         So, standard syntax of lambda is as follows:

         () -> some expression
         Or
         (arguments) -> { body just like function }

         * why lambda
         * simple and efficiency
         */

        users.sort(((o1, o2) -> {
            return o1.getId()-o2.getId();
        }));
    }

    /**
     *  队列 方法测试 ============================>队列方法测试
     * @param node
     */
    @Override
    public void addFirst(User node) {
        users.addFirst(node);
    }

    @Override
    public boolean offer(User node) {

        return users.offer(node);
    }

    @Override
    public void sychronizedVisit(User node) {
        /**
         * 注意采用这种方法实现线程安全
         */
        Collections.synchronizedCollection(users).add(node);
    }

    @Override
    public void push(User node) {
        users.push(node);
    }

    @Override
    public User pop() {
        return users.pop();
    }
}
