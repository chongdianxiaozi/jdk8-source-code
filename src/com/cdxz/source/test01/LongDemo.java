package com.cdxz.source.test01;

public class LongDemo {
    public static void main(String[] args) {
        Long a = 128L;
        System.out.println(a);
        System.out.println(Long.valueOf(128));
        System.out.println(Long.valueOf("128"));
        System.out.println(Long.valueOf("128", 10));
        long b = 128;
        System.out.println(b);
        System.out.println(Long.parseLong("128"));
        System.out.println(Long.parseLong("128", 10));
    }
}
