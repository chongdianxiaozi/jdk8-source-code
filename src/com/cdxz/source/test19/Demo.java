package com.cdxz.source.test19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // submit 提交任务
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " is run"));
    }

}
