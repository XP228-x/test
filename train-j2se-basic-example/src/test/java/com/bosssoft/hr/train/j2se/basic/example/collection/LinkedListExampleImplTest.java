package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListExampleImplTest {

    private LinkedListExampleImpl linkedListExample;
    @Before
    public void setUp() throws Exception {
        linkedListExample = new LinkedListExampleImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void append() {
        User user=new User();
        user.setId(1);
        assertTrue(linkedListExample.append(user));
    }


    @Test
    public void get() {
        User user=new User();
        user.setId(1);
        linkedListExample.append(user);
        assertEquals(user,linkedListExample.get(0));
    }

    @Test
    public void insert() {
        User user=new User();
        user.setId(1);
        User user1=new User();
        linkedListExample.append(user);
        assertTrue(linkedListExample.insert(0,user1));
    }

    @Test
    public void remove() {
        User user=new User();
        user.setId(1);
        linkedListExample.append(user);
        assertEquals(user,linkedListExample.get(0));
        linkedListExample.remove(0);
        assertNull(linkedListExample.get(0));
    }

    @Test
    public void listByIndex() {
        User user1=new User();
        User user2=new User();
        User user3=new User();
        user1.setName("java");
        user2.setName("php");
        user3.setName("xml");
        linkedListExample.append(user1);
        linkedListExample.append(user2);
        linkedListExample.append(user3);
        linkedListExample.listByIndex();
    }

    @Test
    public void listByIterator() {
        User user1=new User();
        User user2=new User();
        User user3=new User();
        user1.setName("java");
        user2.setName("php");
        user3.setName("xml");
        linkedListExample.append(user2);
        linkedListExample.append(user3);
        linkedListExample.append(user1);
        linkedListExample.listByIterator();
    }

    @Test
    public void toArray() {
        User user1=new User();
        User user2=new User();
        user1.setName("java");
        user2.setName("php");
        User[] user={user1,user2};
        linkedListExample.append(user1);
        linkedListExample.append(user2);
        assertArrayEquals(user,linkedListExample.toArray());
    }

    @Test
    public void sort() {
        User user1=new User();
        user1.setId(1);
        User user2=new User();
        user2.setId(2);
        User user3=new User();
        user3.setId(3);
        linkedListExample.append(user3);
        linkedListExample.append(user1);
        linkedListExample.append(user2);
        linkedListExample.sort();
        assertEquals(user1,linkedListExample.get(0));
    }

    @Test
    public void sort2() {
        User user1=new User();
        user1.setId(1);
        User user2=new User();
        user2.setId(2);
        User user3=new User();
        user3.setId(3);
        linkedListExample.append(user3);
        linkedListExample.append(user1);
        linkedListExample.append(user2);
        linkedListExample.sort2();
        assertEquals(user1,linkedListExample.get(0));
    }

    @Test
    public void addFirst() {
        User user1=new User();
        user1.setId(1);
        User user2=new User();
        user2.setId(2);
        linkedListExample.append(user1);
        linkedListExample.addFirst(user2);
        assertEquals(user2,linkedListExample.get(0));
    }

    @Test
    public void offer() {
        User user=new User();
        assertTrue(linkedListExample.offer(user));
    }

    @Test
    public void sychronizedVisit() {
        User user1=new User();
        user1.setId(1);
        User user2=new User();
        user2.setId(2);
        linkedListExample.sychronizedVisit(user1);
        linkedListExample.sychronizedVisit(user2);
        assertEquals(user1,linkedListExample.get(0));
    }

    @Test
    public void push() {
        User user=new User();
        linkedListExample.push(user);
        assertEquals(user,linkedListExample.get(0));
    }

    @Test
    public void pop() {
        User user1=new User();
        user1.setId(1);
        linkedListExample.push(user1);
        User user=new User();
        user.setId(2);
        linkedListExample.push(user);
        assertEquals(linkedListExample.pop(),user);

    }
}