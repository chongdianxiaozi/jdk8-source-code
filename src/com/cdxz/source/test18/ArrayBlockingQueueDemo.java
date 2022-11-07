package com.cdxz.source.test18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            add("a");
            add("b");
            add("c");
        }};
        ArrayBlockingQueue queue = new ArrayBlockingQueue(2, true, list);
    }
}
