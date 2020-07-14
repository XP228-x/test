package com.bosssoft.hr.train.j2se.basic.example.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Task implements Runnable{
    int id;
    public Task(int id){
        this.id=id;
    }

    @Override
    public void run() {
        log.info(this+"完成");
    }
    @Override
    public String toString(){
        return id+"号任务";
    }
}
