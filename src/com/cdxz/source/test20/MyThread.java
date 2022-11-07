package com.cdxz.source.test20;

// 继承 Thread，实现其 run 方法
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}


