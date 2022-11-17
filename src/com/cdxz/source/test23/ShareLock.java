package com.cdxz.source.test23;

import java.io.Serializable;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 共享不公平锁
 */
public class ShareLock implements Serializable {

    // 同步器
    private final Sync sync;
    // 用于确保不能超过的最大值
    private final int maxCount;

    /**
     * 初始化时给同步器 sync 赋值
     * count 表示可以获得共享锁的最大值
     * @param count
     */
    public ShareLock(int count) {
        this.sync = new Sync(count);
        this.maxCount = count;
    }

    /**
     * 获得锁
     * @return true 表示成功获得锁, false 表示失败
     */
    public boolean lock() {
        return sync.acquireByShared(1);
    }

    /**
     * 释放锁
     * @return true 表示成功释放锁, false 表示失败
     */
    public boolean unLock() {
        return sync.tryReleaseShared(1);
    }

    /**
     * 定义同步器Sync
     */
    class Sync extends AbstractQueuedSynchronizer {
        // 表示最多有 count 个共享锁可以获得
        public Sync(int count) {
            setState(count);
        }

        // 获得 i 个锁
        public boolean acquireByShared(int i) {
            // 自旋保证 CAS 一定可以成功
            for(;;) {
                if(i <= 0) {
                    return false;
                }
                int state = getState();
                // 如果没有锁可以获得,直接返回false
                if(state <= 0) {
                    return false;
                }
                int expectState = state - i;
                // 如果要得到的锁不够了,直接返回false
                if(expectState < 0) {
                    return false;
                }
                // CAS 尝试得到锁,CAS成功获得锁返回true,失败继续for循环
                if(compareAndSetState(state, expectState)) {
                    return true;
                }
            }
        }

        // 释放 i 个锁
        @Override
        protected boolean tryReleaseShared(int arg) {
            for(;;) {
                if(arg <= 0) {
                    return false;
                }
                int state = getState();
                int expectState = state + arg;
                // 超过 int 的最大值 或者 expectState 超过了最大预期值
                if(expectState < 0 || expectState > maxCount) {
                    System.out.println("state 超过预期,当前 state is " + state + ",计算出的 state is " + expectState);
                    return false;
                }
                if(compareAndSetState(state, expectState)) {
                    return true;
                }
            }
        }
    }

}
