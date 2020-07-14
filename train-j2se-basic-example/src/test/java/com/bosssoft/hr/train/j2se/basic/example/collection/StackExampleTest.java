package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackExampleTest {
    StackExampleImpl stackExample;

    @Before
    public void setUp()throws Exception{
        stackExample =new StackExampleImpl();
    }
    @After
    public void tearDown(){
    }
    @Test
    public void push(){
        User user=new User();
        user.setId(1);
        assertEquals(user,stackExample.push(user));

    }
    @Test
    public void pop(){
        User user=new User();
        user.setId(1);
        assertEquals(user,stackExample.push(user));
        assertEquals(user,stackExample.pop());
    }
    @Test
    public void peek(){
        User user1=new User();
        User user2=new User();
        user1.setId(1);
        user2.setId(2);
        stackExample.push(user1);
        stackExample.push(user2);
        assertEquals(stackExample.peek(),user2);

    }
    @Test
    public void empty(){
        assertTrue(stackExample.empty());
        User user=new User();
        stackExample.push(user);
        assertFalse(stackExample.empty());
    }
}
