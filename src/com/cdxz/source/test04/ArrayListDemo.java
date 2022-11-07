package com.cdxz.source.test04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        test01();

        test02();
    }

    private static void test02() {
        List<String> list = new ArrayList<String>() {{
            add("2");
            add("3");
            add("3");
            add("3");
            add("4");
        }};
        System.out.println(list.toString());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("3")) {
                list.remove(i);
            }
        }
        System.out.println(list.toString());
    }

    private static void test01() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("hello,world");
        Object[] objects = arrayList.toArray();
        System.out.println(objects.getClass().getSimpleName());
        objects[0] = new Object();
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        Object[] array = list.toArray();
        System.out.println(array.getClass().getSimpleName());
        array[0] = new Object();
        List<String> asList = Arrays.asList("hi");
        // asList.add("ok"); // 报错
        Object[] toArray = asList.toArray();
        System.out.println(toArray.getClass().getSimpleName());
        // toArray[0] = new Object(); // 报错
        toArray[0] = "hello";
    }
}
