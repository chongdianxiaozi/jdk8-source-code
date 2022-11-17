package com.cdxz.source.test22;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 批量退款场景
 * 一个订单50个商品,退款其中30个
 */
public class BatchRefundDemo {

    public static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(20));

    public static void main(String[] args) throws InterruptedException {
        BatchRefundDemo demo = new BatchRefundDemo();
        demo.batchRefund();
    }

    public void batchRefund() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(30);
        RefundDemo refundDemo = new RefundDemo();

        // 准备 30 个商品
        List<Long> items = new ArrayList<>();
        for (long i = 0; i < 30; i++) {
            items.add(i);
        }

        long begin = System.currentTimeMillis();
        // 准备开始批量退款
        List<Future> futures = new ArrayList<>();
        for (Long item : items) {
            Future<Boolean> future = EXECUTOR_SERVICE.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    boolean result = refundDemo.refundByItem(item);
                    countDownLatch.countDown();
                    return result;
                }
            });
            futures.add(future);
        }

        System.out.println("30 个商品已经在退款中");
        countDownLatch.await();
        System.out.println("30 个商品已经退款完成");
        List<Boolean> result = futures.stream().map(fu -> {
            try {
                return (Boolean)fu.get(1, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());

        long success = result.stream().filter(r -> r.equals(true)).count();
        System.out.println("执行结果成功:" + success + ",失败:" + (result.size() - success));
        System.out.println("耗时:" + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        for (Long item : items) {
            refundDemo.refundByItem(item);
        }
        System.out.println("for 循环单个退款耗时:" + (System.currentTimeMillis() - begin));
    }
}
