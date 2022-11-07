package com.cdxz.source.test06;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("a", new Object());
        map.put(null, 1);
        map.put(null, null);
        map.put(1, null);
        System.out.println(map.toString());
    }
}
