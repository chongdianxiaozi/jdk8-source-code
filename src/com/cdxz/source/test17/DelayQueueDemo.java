package com.cdxz.source.test17;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
    public static void main(String[] args) {
        BlockingQueue q = new DelayQueue();
        DelayQueueDemo.Product p = new DelayQueueDemo.Product(q);
        DelayQueueDemo.Consumer c = new DelayQueueDemo.Consumer(q);
        new Thread(c).start();
        new Thread(p).start();
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
                long beginTime = System.currentTimeMillis();
                queue.put(new DelayedDTO(System.currentTimeMillis() + 2000L, beginTime)); // 延迟2秒钟执行
                queue.put(new DelayedDTO(System.currentTimeMillis() + 5000L, beginTime)); // 延迟5秒钟执行
                queue.put(new DelayedDTO(System.currentTimeMillis() + 1000L * 10, beginTime)); // 延迟10秒钟执行
                System.out.println("end put");
            } catch (InterruptedException e) {
                System.out.println(e);
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
                ((DelayedDTO) queue.take()).run();
                ((DelayedDTO) queue.take()).run();
                ((DelayedDTO) queue.take()).run();
                System.out.println("Consumer end");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    static class DelayedDTO implements Delayed {
        Long s;
        Long beginTime;
        public DelayedDTO(Long s, Long beginTime) {
            this.s = s;
            this.beginTime = beginTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(s - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        public void run() {
            System.out.println("现在已经过了" + (System.currentTimeMillis() - beginTime)/1000 + "秒钟");
        }
    }
}
