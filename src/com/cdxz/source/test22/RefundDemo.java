package com.cdxz.source.test22;

/**
 * 根据商品 ID 进行退款
 */
public class RefundDemo {

    /**
     * 根据商品 ID 进行退款
     * @param itemId
     * @return
     */
    public boolean refundByItem(Long itemId) {
        try {
            // 线程沉睡30毫秒,模拟单个商品退款过程
            Thread.sleep(30);
            System.out.println("refund success,itemId is " + itemId);
            return true;
        } catch (Exception e) {
            System.out.println("refundByItemError,itemId is " + itemId);
            return false;
        }
    }
}
