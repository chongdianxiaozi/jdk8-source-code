package com.cdxz.source.test20;

/**
 * 死锁demo
 */
public class ThreadDemo5 {
    // 共享变量 1
    private static final Object share1 = new Object();
    // 共享变量 2
    private static final Object share2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 初始化线程 1，线程 1 需要在锁定 share1 共享资源的情况下再锁定 share2
        Thread thread1 = new Thread(() -> {
            synchronized (share1){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (share2){
                    System.out.println(Thread.currentThread().getName() + " is run");
                }
            }
        });

        // 初始化线程 2，线程 2 需要在锁定 share2 共享资源的情况下再锁定 share1
        Thread thread2 = new Thread(() -> {
            synchronized (share2){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (share1){
                    System.out.println(Thread.currentThread().getName() + " is run");
                }
            }
        });
        // 当线程 1、2 启动后，都在等待对方锁定的资源，但都得不到，造成死锁
        thread1.start();
        thread2.start();
        Thread.sleep(10_0000_0000);
    }

}
