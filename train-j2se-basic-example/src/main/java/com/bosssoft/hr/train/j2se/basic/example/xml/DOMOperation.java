package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.stream.IntStream;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:13
 * @since
 **/
public class DOMOperation implements XMLOperation<Student> {
    private Document document;
    private String path="D:/java/boss/bosssoft-train-example-master-f13eb7c7eb01f08e2b554a45b3560cdcce43726c/train-j2se-basic-example/src/main/java/com/bosssoft/hr/train/j2se/basic/example/xml/student.xml";

    public void init(){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            document = builder.parse(new FileInputStream(path));
        } catch (ParserConfigurationException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public boolean create(Student object) {

        Element student=document.createElement("student");
        student.setAttribute("id",object.getId().toString());
        Element name=document.createElement("name");
        name.setAttribute("name",object.getName());
        Element age=document.createElement("age");
        age.setAttribute("age",object.getAge().toString());
        student.appendChild(name);
        student.appendChild(age);
        document.getDocumentElement().appendChild(student);
        return save();
    }

    private boolean save() {
        TransformerFactory factory=TransformerFactory.newInstance();
        try {
            Transformer transformer=factory.newTransformer();
            factory.setAttribute("indent-number",4);
            transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");
            transformer.setOutputProperty(OutputKeys.INDENT,"YES");
            DOMSource source=new DOMSource(document);
            OutputStream outputStream=new FileOutputStream(path);
            StreamResult streamResult=new StreamResult(new OutputStreamWriter(outputStream));
            transformer.transform(source,streamResult);
            return true;
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (TransformerException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Student object) {

        NodeList nodeList=document.getElementsByTagName("student");
        IntStream.range(0, nodeList.getLength()).mapToObj(i -> (Element) nodeList.item(i)).forEach(element -> {
            Integer integer = Integer.parseInt(element.getAttribute("id"));
            if (integer.equals(object.getId())) {
                element.getParentNode().removeChild(element);
            }
        });
        return save();
    }

    @Override
    public boolean update(Student object) {

        NodeList Student = document.getElementsByTagName("student");
        for(int i=0;i<Student.getLength();i++){
            Element element = (Element)Student.item(i);
            Integer id = Integer.parseInt(element.getAttribute("id"));
            if(id.equals(object.getId())){
                NodeList namelist = element.getElementsByTagName("name");
                ((Element)namelist.item(0)).setAttribute("name",object.getName());
                NodeList agelist = element.getElementsByTagName("age");
                ((Element)agelist.item(0)).setAttribute("age",object.getAge().toString());
            }
        }
        return save();
    }

    @Override
    public Student query(Student object) {
        NodeList nodeList=document.getElementsByTagName("student");
        for(int i=0;i<nodeList.getLength();i++){
            Element element = (Element)nodeList.item(i);
            Integer integer = Integer.parseInt(element.getAttribute("id"));
            if (integer.equals(object.getId())) {
                System.out.println("Found" + object.getName());
                break;
            } else {
                System.out.println("Not found");
            }
        }
        return object;

    }
}
