package com.cdxz.source.test20;

public class ThreadDemo4 {
    public static void main(String[] args) throws InterruptedException {

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是子线程 2,开始执行");
                try {
                    System.out.println("我是子线程 2,开始沉睡");
                    Thread.sleep(2_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是子线程 2，执行完成");
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是子线程 1，开始运行");
                try {
                    System.out.println("我是子线程 1，我在等待子线程 2");
                    thread2.join();
                    System.out.println("我是子线程 1，子线程 2 执行完成，我继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是子线程 1，执行完成");
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(10_0000);
    }
}
