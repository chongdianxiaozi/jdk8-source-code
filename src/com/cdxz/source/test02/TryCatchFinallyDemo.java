package com.cdxz.source.test02;

public class TryCatchFinallyDemo {
    public static void main(String[] args) {
        try {
            System.out.println("try is run");
            if (true) {
                throw new RuntimeException("try exception");
            }
        } catch (Exception e) {
            System.out.println("catch is run");
            if (true) {
                throw new RuntimeException("catch exception");
            }
        } finally {
            System.out.println("finally is run");
        }
    }
}
