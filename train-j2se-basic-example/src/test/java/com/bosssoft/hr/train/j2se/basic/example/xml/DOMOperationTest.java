package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DOMOperationTest {

    DOMOperation operation;

    @Before
    public void setUp() throws Exception {
        operation=new DOMOperation();
        operation.init();
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        Student student=new Student();
        student.setId(3);
        student.setName("kkk");
        student.setAge(18);
        assertTrue(operation.create(student));
    }

    @Test
    public void remove() {
        Student student=new Student();
        student.setId(3);
        student.setName("kkk");
        student.setAge(18);
        assertTrue(operation.remove(student));
    }

    @Test
    public void update() {
        Student student=new Student();
        student.setId(1);
        student.setName("kkk");
        student.setAge(18);
        operation.create(student);
        Student student2 = new Student();
        student2.setId(1);
        student2.setName("Mike");
        student2.setAge(15);
        assertTrue(operation.update(student2));
    }

    @Test
    public void query() {
        Student student=new Student();
        student.setId(1);
        student.setName("ming");
        student.setAge(18);
        operation.create(student);
        operation.query(student);
    }
}