package com.cdxz.source.test20;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // new MyThread().start();
        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " begin run");
            }
        });

        // 开一个子线程去执行
        thread.start();
        // 不会新起线程，是在当前主线程上继续运行
        thread.run();*/

        /*Thread main = Thread.currentThread();
        System.out.println(main.getName() + " is run");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " begin run");
                try {
                    Thread.sleep(3_0000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 开一个子线程去执行
        thread.start();
        // 当前主线程等待子线程执行完成之后再执行
        thread.join();
        System.out.println(Thread.currentThread() + " is end");*/

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " begin run");
                try {
                    System.out.println("子线程开始沉睡 30 s");
                    Thread.sleep(3_0000L);
                } catch (InterruptedException e) {
                    System.out.println("子线程被打断");
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end run");
            }
        });

        // 开一个子线程去执行
        thread.start();
        Thread.sleep(1_000L);
        System.out.println("主线程等待 1s 后，发现子线程还没有运行成功，打断子线程");
        thread.interrupt();
    }
}
