package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ArrayListExampleImplTest {

    ArrayListExampleImpl arrayListExample;
    @Before
    public void setUp() throws Exception {
        arrayListExample = new ArrayListExampleImpl();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void append() {
        User user=new User();
        user.setName("jack");
        boolean flag=arrayListExample.append(user);
        assertTrue(flag);
    }

    @Test
    public void get() {
        User user=new User();
        user.setName("jack");
        arrayListExample.append(user);
        assertEquals(user,arrayListExample.get(0));
    }

    @Test
    public void insert() {
        User user=new User();
        user.setName("jack");
        arrayListExample.insert(0,user);
        assertEquals(user,arrayListExample.get(0));
    }

    @Test
    public void remove() {
        User user=new User();
        user.setName("jack");
        arrayListExample.append(user);
        boolean flag=arrayListExample.remove(0);
        assertTrue(flag);
    }

    @Test
    public void listByIndex() {
        User user1=new User();
        User user2=new User();
        User user3=new User();
        user1.setName("java");
        user2.setName("php");
        user3.setName("xml");
        arrayListExample.append(user1);
        arrayListExample.append(user2);
        arrayListExample.append(user3);
        arrayListExample.listByIndex();

    }

    @Test
    public void listByIterator() {
        User user1=new User();
        User user2=new User();
        User user3=new User();
        user1.setName("java");
        user2.setName("php");
        user3.setName("xml");
        arrayListExample.append(user2);
        arrayListExample.append(user3);
        arrayListExample.append(user1);
        arrayListExample.listByIterator();
    }

    @Test
    public void toArray() {
        User user1=new User();
        User user2=new User();
        user1.setName("java");
        user2.setName("php");
        User[] user={user1,user2};
        arrayListExample.append(user1);
        arrayListExample.append(user2);

        assertArrayEquals(user,arrayListExample.toArray());
    }

    @Test
    public void sort() {
        User user1=new User();
        user1.setId(1);
        User user2=new User();
        user2.setId(2);
        User user3=new User();
        user3.setId(3);
        arrayListExample.append(user3);
        arrayListExample.append(user1);
        arrayListExample.append(user2);
        arrayListExample.sort();
        assertEquals(user1,arrayListExample.get(0));
    }

    @Test
    public void sort2() {
        User user1=new User();
        user1.setId(1);
        User user2=new User();
        user2.setId(2);
        User user3=new User();
        user3.setId(3);
        arrayListExample.append(user3);
        arrayListExample.append(user1);
        arrayListExample.append(user2);
        arrayListExample.sort2();
        assertEquals(user1,arrayListExample.get(0));
    }
}