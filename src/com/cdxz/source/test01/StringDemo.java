package com.cdxz.source.test01;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringDemo {
    public static void main(String[] args) {
        // test1();
        // test2();
        // test3();
        test4();


    }

    private static void test4() {
        String s ="boo:and:foo";
        System.out.println(Arrays.toString(s.split(":"))); // 结果:["boo","and","foo"]
        System.out.println(Arrays.toString(s.split(":",2))); // 结果:["boo","and:foo"]
        System.out.println(Arrays.toString(s.split(":",5))); // 结果:["boo","and","foo"]
        System.out.println(Arrays.toString(s.split(":",-2))); // 结果:["boo","and","foo"]
        System.out.println(Arrays.toString(s.split("o"))); // 结果:["b","",":and:f"]
        System.out.println(Arrays.toString(s.split("o",2))); // 结果:["b","o:and:foo"]
        String a =",a,,b,";
        System.out.println(Arrays.toString(a.split(","))); // 结果:["","a","","b"]

        // ===末尾的空值自动去除==========================
        String b ="boo";
        System.out.println(Arrays.toString(b.split("o"))); // 结果:["b"]
        String c ="oob";
        System.out.println(Arrays.toString(c.split("o"))); // 结果:["","","b"]
        //============================================

        List<String> aList = new ArrayList<>();
        aList.add("你好");
        aList.add("中国");
        aList.add("杭州");
        String aStr = String.join(",", aList);
        System.out.println(aStr);

        String bArr[] = new String[]{"1", "2", "3", "4"};
        String bStr = String.join(":", bArr);
        System.out.println(bStr);
        String cArr[] = {"a", "b", "c"};
        String cStr = String.join(";", cArr);
        System.out.println(cStr);
        String dArr[] = new String[2];
        dArr[0] = "欢迎";
        dArr[1] = "您";
        String dStr = String.join("-", dArr);
        System.out.println(dStr);

        String eArr[] = {"hello", "world", "", "", "!"};
        String eStr = String.join(":", eArr);
        System.out.println(eStr);
    }

    private static void test3() {
        String str ="hello word !!";
        System.out.println("替换之前 :" + str);
        str = str.replace('l','d');
        System.out.println("替换所有字符 :" + str);
        str = str.replaceAll("d","l");
        System.out.println("替换全部 :" + str);
        str = str.replaceFirst("l","");
        System.out.println("替换第一个 l :" + str);
    }

    private static void test2() {
        String str = "nihao 你好 喬亂";
        try {
            byte[] bytes = str.getBytes("ISO-8859-1"); // 字符串转化为byte数组
            String s2 = new String(bytes); // byte数组转化为字符串
            System.out.println(s2); // 结果打印为：nihao ?? ??
            String s3 = new String(bytes, "ISO-8859-1"); // 指定转化类型
            System.out.println(s3); // 结果打印为：nihao ?? ??
            String s4 = new String(bytes, "UTF-8"); // 指定转化类型
            System.out.println(s4); // 结果打印为：nihao ?? ??
            byte[] bytes1 = str.getBytes("UTF-8");
            String s5 = new String(bytes1, "UTF-8");
            System.out.println(s5); // 结果打印为：nihao 你好 喬亂

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test1() {
        String s = "hello";
        s = "world";
        System.out.println(s);
        String str = "hello world!";
        // 这种写法是替换不了的,必须接收replace方法返回的参数才行
        str.replace("l", "dd");
        System.out.println(str);
        str = str.replace("l", "dd");
        System.out.println(str);
    }

}
