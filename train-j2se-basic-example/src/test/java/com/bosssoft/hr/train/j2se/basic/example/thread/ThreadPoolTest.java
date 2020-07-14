package com.bosssoft.hr.train.j2se.basic.example.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

@Slf4j
public class ThreadPoolTest {
    private ThreadPoolImpl threadPool;
    @Before
    public void setUp()throws Exception{
        threadPool=new ThreadPoolImpl(3,5);
    }
    @After
    public void tearDown()throws Exception{
    }
    @Test
    public void execute(){
        for (int i=0;i<10;i++){
            Task task= new Task(i);
            if (!threadPool.execute(task)){
                log.info(task+"build failed");
            }
        }
        assertTrue(true);
    }
}
