package com.cdxz.source.test14;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        test();

        int r = test2();
        System.out.println(r);

        test3();

        test4();

        test5();

    }

    private static int test5() {
        for (int i = 0; ; ) {
            if(i == 0) {
                System.out.println(i);
                return 0;
            }
            System.out.println("before break");
            break;
        }

        return 3;
    }

    private static void test4() {
        int sc = 16 - (16 >>> 2);
        System.out.println(sc);
        int b = 16 >>> 2;
        System.out.println(b);
        int c = 64 >>> 2;
        System.out.println(c);
    }

    private static void test3() {
        ConcurrentHashMap map = new ConcurrentHashMap();
        Object a = map.put(1, "a");
        System.out.println(a); // null
        Object b = map.put(1, "b");
        System.out.println(b); // a
    }

    private static int test2() {
        for (int i = 0; i < 100; i++) {
            if(i == 10) {
                System.out.println(i);
                return 3;
            }
        }
        int j = 0;
        return j;
    }

    private static void test() {
        ConcurrentHashMap map = new ConcurrentHashMap();
        // map.put(null, 1);
        // map.put(1, null);
        map.put(1, 1);
        System.out.println(map.toString());
    }

}
