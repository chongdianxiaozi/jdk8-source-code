package com.cdxz.source.test24;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor;
        Executors executors;
        System.out.println(Integer.SIZE);
        int a = 29;
        System.out.println(1<<a);
        System.out.println(-1<<a);
        System.out.println(2<<a);
        System.out.println(3<<a);
    }
}
