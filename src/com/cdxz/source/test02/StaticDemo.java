package com.cdxz.source.test02;

import java.util.ArrayList;
import java.util.List;

public class StaticDemo extends ParentStaticDemo {
    public static List<String> LIST = new ArrayList() {{
        System.out.println("子类静态变量初始化");
    }};

    static {
        System.out.println("子类静态块初始化");
    }

    public StaticDemo() {
        System.out.println("子类构造器初始化");
    }

    public static void testStatic() {
        System.out.println("子类静态方法被调用");
    }

    public static void main(String[] args) {
        System.out.println("main 方法执行");
        new StaticDemo();
    }

}
