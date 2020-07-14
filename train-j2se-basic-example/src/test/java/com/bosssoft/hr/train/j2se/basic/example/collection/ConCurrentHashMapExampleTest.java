package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Resource;
import com.bosssoft.hr.train.j2se.basic.example.pojo.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConCurrentHashMapExampleTest {
    private ConcurrentHashMapExampleImpl conCurrenHashMapExample;

    @Before
    public void setUp() throws Exception {
        conCurrenHashMapExample=new ConcurrentHashMapExampleImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void put() {
        Role key=new Role();
        Resource value = new Resource();
        assertNull(conCurrenHashMapExample.put(key,value));

    }

    @Test
    public void remove() {
        Role key=new Role();
        Resource value=new Resource();
        key.setId(1);
        value.setId(100);
        conCurrenHashMapExample.put(key,value);
        assertEquals(value,conCurrenHashMapExample.remove(key));
    }

    @Test
    public void containsKey() {
        Role key=new Role();
        Resource value=new Resource();
        key.setId(1);
        value.setId(100);
        conCurrenHashMapExample.put(key,value);
        assertTrue(conCurrenHashMapExample.containsKey(key));
    }

    @Test
    public void visitByEntryset_Lambda(){
        Role key1=new Role();
        Resource value1=new Resource();
        key1.setId(1);
        value1.setId(100);
        conCurrenHashMapExample.put(key1,value1);
        Role key2=new Role();
        Resource value2=new Resource();
        key2.setId(2);
        value2.setId(20);
        conCurrenHashMapExample.put(key2,value2);
        Role key3=new Role();
        Resource value3=new Resource();
        key3.setId(3);
        value3.setId(30);
        conCurrenHashMapExample.put(key3,value3);
        conCurrenHashMapExample.visitByEntryset_Lambda();
    }

    @Test
    public void visitByEntryset() {

        Role key1=new Role();
        Resource value1=new Resource();
        key1.setId(1);
        value1.setId(100);
        conCurrenHashMapExample.put(key1,value1);
        Role key2=new Role();
        Resource value2=new Resource();
        key2.setId(2);
        value2.setId(20);
        conCurrenHashMapExample.put(key2,value2);
        Role key3=new Role();
        Resource value3=new Resource();
        key3.setId(3);
        value3.setId(30);
        conCurrenHashMapExample.put(key3,value3);
        conCurrenHashMapExample.visitByEntryset();
    }

    @Test
    public void visitByKeyset() {
        Role key1=new Role();
        Resource value1=new Resource();
        key1.setId(1);
        value1.setId(100);
        conCurrenHashMapExample.put(key1,value1);
        Role key2=new Role();
        Resource value2=new Resource();
        key2.setId(2);
        value2.setId(20);
        conCurrenHashMapExample.put(key2,value2);
        Role key3=new Role();
        Resource value3=new Resource();
        key3.setId(3);
        value3.setId(30);
        conCurrenHashMapExample.put(key3,value3);
        conCurrenHashMapExample.visitByKeyset();
    }

    @Test
    public void visitByValues() {
        Role key1=new Role();
        Resource value1=new Resource();
        key1.setId(1);
        value1.setId(100);
        conCurrenHashMapExample.put(key1,value1);
        Role key2=new Role();
        Resource value2=new Resource();
        key2.setId(2);
        value2.setId(20);
        conCurrenHashMapExample.put(key2,value2);
        Role key3=new Role();
        Resource value3=new Resource();
        key3.setId(3);
        value3.setId(30);
        conCurrenHashMapExample.put(key3,value3);
        conCurrenHashMapExample.visitByValues();
    }
}
