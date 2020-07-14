package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description: 演示如何使用 比较器排序 ，另外一种方式 User 实现比较接口这种对
 * User 类存在侵入
 * @author: Administrator
 * @create: 2020-05-28 21:56
 * @since
 **/
public class TreeSetExampleImpl implements TreeSetExmaple<User> {
   private Set<User> set=new TreeSet<>(new Comparator<User>() {
       @Override
       public int compare(User o1, User o2) {
           return o1.getId()-o2.getId();
       }
   }) ;
    @Override
    public User[] sort(User[] arry) {
        if(null!=arry && arry.length>0){
            for (User user: arry) {
                set.add(user); // 因为比较器的存在加入的时候将按顺序排列
            }
            User[] users=set.toArray(new User[0]);
            return users;
        }else
            return null;
    }
}
