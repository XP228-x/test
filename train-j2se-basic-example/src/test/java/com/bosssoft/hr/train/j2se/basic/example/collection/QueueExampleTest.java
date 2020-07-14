package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueExampleTest {
    QueueExampleImpl queueExample;

    @Before
    public void setUp()throws Exception{
        queueExample=new QueueExampleImpl();
    }
    @After
    public void tearDown(){
    }
    @Test
    public void push(){
        User user=new User();
        user.setId(1);
        assertTrue(queueExample.push(user));

    }
    @Test
    public void pop(){
        User user=new User();
        user.setId(1);
        assertTrue(queueExample.push(user));
        assertEquals(user,queueExample.pop());
    }
    @Test
    public void peek(){
        User user1=new User();
        User user2=new User();
        user1.setId(1);
        user2.setId(2);
        queueExample.push(user1);
        queueExample.push(user2);
        assertEquals(queueExample.peek(),user2);

    }
    @Test
    public void empty(){
        assertTrue(queueExample.empty());
        User user=new User();
        queueExample.push(user);
        assertFalse(queueExample.empty());
    }
}
