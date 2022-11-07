package com.cdxz.source.test16;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;


public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue q = new SynchronousQueue(true);
        Product p = new Product(q);
        Consumer c = new Consumer(q);
        new Thread(c).start();
        System.out.println("sleeping");
        Thread.sleep(5000L);
        System.out.println("sleepEnd");
        new Thread(p).start();
    }

    static String producy(String name) {
        return name;
    }

    static class Product implements Runnable {

        private final BlockingQueue queue;

        public Product(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println("begin put");
                queue.put(producy("hello"));
                System.out.println("end put");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Consumer implements Runnable {

        private final BlockingQueue queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println("Consumer begin");
                String name = (String)queue.take();
                System.out.println("Consumer end:" + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
