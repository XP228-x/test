package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Resource;
import com.bosssoft.hr.train.j2se.basic.example.pojo.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeMapExampleTest {
    private TreeMapExampleImpl treeMapExample;

    @Before
    public void setUp() throws Exception {
        treeMapExample=new TreeMapExampleImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void put() {
        Role key=new Role();
        Resource value = new Resource();
        assertNull(treeMapExample.put(key,value));

    }

    @Test
    public void remove() {
        Role key=new Role();
        Resource value=new Resource();
        key.setId(1);
        value.setId(100);
        treeMapExample.put(key,value);
        assertEquals(value,treeMapExample.remove(key));
    }

    @Test
    public void containsKey() {
        Role key=new Role();
        Resource value=new Resource();
        key.setId(1);
        value.setId(100);
        treeMapExample.put(key,value);
        assertTrue(treeMapExample.containsKey(key));
    }

    @Test
    public void visitByEntryset() {

        Role key1=new Role();
        Resource value1=new Resource();
        key1.setId(1);
        value1.setId(100);
        treeMapExample.put(key1,value1);
        Role key2=new Role();
        Resource value2=new Resource();
        key2.setId(2);
        value2.setId(20);
        treeMapExample.put(key2,value2);
        Role key3=new Role();
        Resource value3=new Resource();
        key3.setId(3);
        value3.setId(30);
        treeMapExample.put(key3,value3);
        treeMapExample.visitByEntryset();
    }

    @Test
    public void visitByKeyset() {
        Role key1=new Role();
        Resource value1=new Resource();
        key1.setId(1);
        value1.setId(100);
        treeMapExample.put(key1,value1);
        Role key2=new Role();
        Resource value2=new Resource();
        key2.setId(2);
        value2.setId(20);
        treeMapExample.put(key2,value2);
        Role key3=new Role();
        Resource value3=new Resource();
        key3.setId(3);
        value3.setId(30);
        treeMapExample.put(key3,value3);
        treeMapExample.visitByKeyset();
    }

    @Test
    public void visitByValues() {
        Role key1=new Role();
        Resource value1=new Resource();
        key1.setId(1);
        value1.setId(100);
        treeMapExample.put(key1,value1);
        Role key2=new Role();
        Resource value2=new Resource();
        key2.setId(2);
        value2.setId(20);
        treeMapExample.put(key2,value2);
        Role key3=new Role();
        Resource value3=new Resource();
        key3.setId(3);
        value3.setId(30);
        treeMapExample.put(key3,value3);
        treeMapExample.visitByValues();
    }
}
