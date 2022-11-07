package com.cdxz.source.test20;

import java.util.concurrent.*;

public class ThreadDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        // 线程任务:FutureTask,构造器入参为 Callable
        FutureTask futureTask = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3_000L);
                return "我是子线程" + Thread.currentThread().getName();
            }
        });
        // 把任务提交到线程池中,线程池会分配线程去执行任务
        threadPoolExecutor.submit(futureTask);
        // 得到任务执行的结果
        String result = (String)futureTask.get();
        System.out.println("result is " + result);
    }
}
