package com.jia.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
 
public class SimpleTask implements Callable<Integer> {
 
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(2);
 
        SimpleTask task1 = new SimpleTask();
        SimpleTask task2 = new SimpleTask();
 
        ArrayBlockingQueue
        
        Future<Integer> f1 = es.submit(task1);
        Future<Integer> f2 = es.submit(task2);
 
        Integer result = f1.get() + f2.get();   //blocking call as wait for the results
 
        System.out.println(Thread.currentThread().getName() + " I was blocked until the results are computed");
        System.out.println(Thread.currentThread().getName() + " result=" + result);
 
        es.awaitTermination(5L, TimeUnit.SECONDS);
        es.shutdown();
    }
 
    @Override
    public Integer call() throws InterruptedException {
       System.out.println(Thread.currentThread().getName() + " Started");
       Thread.sleep(8000); // 2000ms processing time
       System.out.println(Thread.currentThread().getName() + " Done");
       return 123; // fake result
    }
}