package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:06
 * @since
 **/
public interface XMLOperation<T extends Student> {
    boolean create(T object);
    boolean remove(T object);
    boolean update(T object);
    T query(T object) throws ParserConfigurationException, SAXException, IOException;

}
