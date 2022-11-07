package com.cdxz.source.test08;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(4, 0.75f, true) {
            {
                put(10, 10);
                put(9, 9);
                put(20, 20);
                put(1, 1);
            }

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                // 覆写了删除策略的方法，我们设定当节点个数大于 3 时，就开始删除头节点
                return size() > 3;
            }
        };

        System.out.println("初始化:" + map.toString());
        map.get(9);
        System.out.println("map.get(9):" + map.toString());
        map.get(20);
        System.out.println("map.get(20):" + map.toString());
    }
}
