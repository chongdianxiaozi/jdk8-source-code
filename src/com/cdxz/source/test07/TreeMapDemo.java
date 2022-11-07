package com.cdxz.source.test07;

import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {
        // 第一种排序，从小到大排序，实现 Comparable 的 compareTo 方法进行排序
        List<DTO> list = new ArrayList<>();
        for (int i = 5; i > 0; i--) {
            list.add(new DTO(i));
        }

        Collections.sort(list);
        System.out.println(list);

        // 第二种排序，从大到小排序，利用外部排序器 Comparator 进行排序
        Comparator comparator = (Comparator<DTO>) (o1, o2) -> o2.getId() - o1.getId();
        Collections.sort(list, comparator);
        System.out.println(list);
    }
}
