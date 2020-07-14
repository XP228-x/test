package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;

import static org.junit.Assert.*;

public class SAXOperatironTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void update() {
    }

    @Test
    public void query() throws IOException, SAXException, ParserConfigurationException {
        SAXOperatiron saxOperation = new SAXOperatiron();
        Student student=new Student();
        student.setName("mark");
        student.setId(0);
        student.setAge(22);
        saxOperation.query(student);
    }
}