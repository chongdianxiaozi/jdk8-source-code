package com.cdxz.source.test12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JDK78Demo {
    public static void main(String[] args) {
        test1();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(10, 10);
        System.out.println("compute 之前值为：" + map.get(10));
        map.compute(10, (key, value) -> key * value);
        System.out.println("compute 之后值为：" + map.get(10));
        map.put(10, 10);

        // 如果为 11 的 key 不存在的话，需要注意 value 为空的情况，下面这行代码就会报空指针
        // map.compute(11,(key,value) -> key * value);
        // 为了防止 key 不存在时导致的未知异常，我们一般有两种办法
        // 1：自己判断空指针
        map.compute(11, (key, value) -> null == value ? null : key * value);
        System.out.println("compute 之后值为：" + map.get(11)); // null

        // 2：computeIfPresent 方法里面判断
        map.computeIfPresent(12, (key, value) -> key * value);
        System.out.println("compute 之后值为：" + map.get(12)); // null
    }

    private static void test1() {
        List<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(3);
            add(2);
            add(4);
        }};
        list.forEach(value -> System.out.println("当前值为:" + value));
    }
}
