package com.bosssoft.hr.train.j2se.basic.example.thread;


import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.LinkedList;

@Slf4j
public class ThreadPoolImpl {
    private HashSet<Worker> workers;
    private LinkedList<Runnable> linkedList;
    private int corePoolSize;
    private int queueCapacity;
    int workCount = 0;

    public ThreadPoolImpl(int corePoolSize,int queueCapacity){
        workers=new HashSet<>();
        linkedList=new LinkedList<>();
        this.corePoolSize=corePoolSize;
        this.queueCapacity=queueCapacity;
    }

    public synchronized boolean execute(Runnable task){
        if (workers.size()>=corePoolSize){
            if (linkedList.size()>=queueCapacity){
                return false;
            }else {
                linkedList.add(task);
                return true;
            }
        }else {
            Worker worker=new Worker(workCount++,task);
            workers.add(worker);
            return true;
        }
    }
    @EqualsAndHashCode(callSuper = true)
    class Worker extends Thread{
        int id;
        Runnable task;

        public Worker(int id,Runnable task){
            this.id=id;
            this.task=task;
            this.start();
            log.info(this+"创建"+task);
        }

        @Override
        public void run(){
            if (task!=null){
                task.run();
            }
            task=getTask(this);
            while(task!=null){
                task.run();
                task=getTask(this);
            }
            workers.remove(Worker.this);
            log.info(this+"退出");
        }

        @Override
        public String toString(){
            return id+"号线程";
        }

        private synchronized Runnable getTask(Worker worker){
            log.info(worker+"执行任务"+linkedList.peek());
            return linkedList.poll();
        }
    }

}
