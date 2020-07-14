package com.bosssoft.hr.train.j2se.basic.example.annotation;


import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Slf4j
public class UserModelTest {
    @Before
    public void setUp()throws Exception{

    }

    @After
    public void tearDown()throws Exception{
    }
    @Test
    public void insert() throws IllegalAccessException, SQLException {
        UserModel userModel=new UserModel();
        userModel.setId(12);

        userModel.setAge(10);
        userModel.setName("插入");
        assertEquals(1,userModel.save());
    }

    @Test
    public void update() throws IllegalAccessException {
        UserModel userModel=new UserModel();
        userModel.setId(12);

        userModel.setAge(10);
        userModel.setName("修改");
        assertEquals(1,userModel.update());
    }

    @Test
    public void remove() throws IllegalAccessException {
        UserModel userModel=new UserModel();
        userModel.setId(12);

        userModel.setAge(10);
        assertEquals(1,userModel.remove());
    }

    @Test
    public void query() throws IllegalAccessException, SQLException {
        UserModel userModel = new UserModel();
        userModel.queryForList();

    }
}
