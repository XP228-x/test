package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeSetExampleImplTest {

    @Test
    public void sort() {
        User user1=new User();
        User user2=new User();
        User user3=new User();
        user1.setId(1);
        user2.setId(2);
        user3.setId(3);
        user1.setName("jack");
        user2.setName("puff");
        user3.setName("rookie");
        User[] users={user1,user2,user3};
        User[] user={user2,user3,user1};
        TreeSetExampleImpl treeSetExample=new TreeSetExampleImpl();
        assertArrayEquals(users,treeSetExample.sort(user));
    }
}