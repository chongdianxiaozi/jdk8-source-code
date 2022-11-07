package com.cdxz.source.test02;

import java.util.ArrayList;
import java.util.List;

public class ParentStaticDemo {
    public static List<String> PARENT_LIST = new ArrayList() {{
        System.out.println("父类静态变量初始化");
    }};

    static {
        System.out.println("父类静态块初始化");
    }

    public ParentStaticDemo() {
        System.out.println("父类构造器初始化");
    }

    public static void testStatic() {
        System.out.println("父类静态方法被调用");
    }

}
