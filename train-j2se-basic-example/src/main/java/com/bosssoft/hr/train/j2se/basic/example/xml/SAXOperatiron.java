package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import lombok.SneakyThrows;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:10
 * @since
 **/
public class SAXOperatiron implements XMLOperation<Student> {
    private String path = "src/main/java/com/bosssoft/hr/train/j2se/basic/example/xml/student.xml";

    @Override
    public boolean create(Student object) {
        return false;
    }

    @Override
    public boolean remove(Student object) {
        return false;
    }

    @Override
    public boolean update(Student object) {
        return false;
    }

    @SneakyThrows
    @Override
    public Student query(Student object) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        FileInputStream inputStream=new FileInputStream(path);
        SAXParser saxParser = factory.newSAXParser();

        saxParser.parse(inputStream, new DefaultHandler(){
            boolean addAge = false;
            boolean addName = false;
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            ArrayList<String> stringArrayList = new ArrayList<>();

            @Override
            public void startDocument() {
                System.out.println("startDocument()");
            }

            @Override
            public void endDocument() {
                System.out.println("endDocument()");
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                String con=new String(ch,start,length);
                if(!con.trim().equals("")) {
                    System.out.println("/characters");
                    System.out.println(new String(ch,start,length));
                    System.out.println("characters/");
                }
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("/startElement");
                System.out.println(uri + localName + qName);
                System.out.println("元素名称:"+qName);
                System.out.println("startElement/");
//                if (qName=="name"){this.addName = true}
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                System.out.println("/endElement");
                System.out.println(uri + localName + qName);
                System.out.println("endElement/");

            }
        });
        return null;
    }
}
