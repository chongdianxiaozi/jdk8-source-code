package com.cdxz.source.test03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysDemo {
    public static void main(String[] args) {
        testSort();
    }

    public static void testSort() {
        List<SortDTO> list = new ArrayList<>();
        list.add(new SortDTO("300"));
        list.add(new SortDTO("50"));
        list.add(new SortDTO("200"));
        list.add(new SortDTO("220"));

        SortDTO[] array = new SortDTO[list.size()];
        list.toArray(array);

        System.out.println("排序之前:" + Arrays.toString(array));
        Arrays.sort(array, Comparator.comparing(SortDTO::getSortTarget));
        System.out.println("排序之后:" + Arrays.toString(array));

        int index = Arrays.binarySearch(array, new SortDTO("200"), Comparator.comparing(SortDTO::getSortTarget));
        if (index < 0) {
            throw new RuntimeException("没有找到 200");
        }
        System.out.println("搜索结果:" + array[index].toString());
    }
}
