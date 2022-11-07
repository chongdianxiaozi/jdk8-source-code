package com.cdxz.source.test20;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                String result = "我是子线程"+Thread.currentThread().getName();
                System.out.println("子线程正在运行:" + Thread.currentThread().getName());
                return result;
            }
        });
        // FutureTask 继承了 Runnable, 可以作为 Thread 构造器入参
        new Thread(futureTask).start();
        System.out.println("返回的结果是:" + futureTask.get());
    }
}
