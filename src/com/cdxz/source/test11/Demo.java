package com.cdxz.source.test11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        test1();
        //test2();

        test3();

    }

    private static void test3() {
        List<Integer> list = new ArrayList<Integer>(){{
           add(1);
           add(2);
           add(3);
           add(4);
        }};

        // 下面这行被注释的代码这么写是无法转化成数组的，无参 toArray 返回的是 Object[],
        // 无法向下转化成 List<Integer>，编译都无法通过
        // List<Integer> list2 = list.toArray();

        // 演示有参 toArray 方法，数组大小不够时，得到数组为 null 情况
        Integer[] array0 = new Integer[2];
        list.toArray(array0);
        System.out.println("toArray 数组大小不够，array0 数组[0],数组[1] 值是：" + array0[0] + "," + array0[1]);

        // 演示数组初始化大小正好，正好转化成数组
        Integer[] array1 = new Integer[list.size()];
        list.toArray(array1);
        System.out.println("toArray 数组大小正好，array1 数组[3] 值是：" + array1[3]);

        // 演示数组初始化大小大于实际所需大小，也可以转化成数组
        Integer[] array2 = new Integer[list.size()+2];
        list.toArray(array2);
        System.out.println("toArray 数组大小多了，array2 数组[3],数组[4] 值是：" +  array2[3] + "," + array2[4]);
    }

    private static void test2() {
        Integer[] array = new Integer[]{1,2,3,4,5,6};
        List<Integer> list = Arrays.asList(array);
        // 坑1：修改数组的值，会直接影响原 list
        System.out.println("数组被修改之前，集合第一个元素为：" + list.get(0));
        array[0] = 10;
        System.out.println("数组被修改之后，集合第一个元素为：" + list.get(0));

        // 坑2：使用 add、remove 等操作 list 的方法时，
        // 会报 UnsupportedOperationException 异常
        list.add(7);
    }

    private static void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3000000; i++) {
            list.add(i);
        }

        // for 循环 + add
        ArrayList<Integer> list2 = new ArrayList<>();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list2.add(list.get(i));
        }
        System.out.println("单个 for 循环新增 300 w 个，耗时：" + (System.currentTimeMillis()-start1));

        // 批量新增
        ArrayList<Integer> list3 = new ArrayList<>();
        long start2 = System.currentTimeMillis();
        list3.addAll(list);
        System.out.println("批量新增 300 w 个，耗时：" + (System.currentTimeMillis()-start2));
    }
}
