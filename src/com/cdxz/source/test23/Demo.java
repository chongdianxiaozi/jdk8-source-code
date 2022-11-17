package com.cdxz.source.test23;

public class Demo {
    public static void main(String[] args) {
        System.out.println("模仿开始获得 mysql 链接");
        MysqlConnection mysqlConnection = new MysqlConnection(10);
        System.out.println("初始化 mysql 链接最大只能获取 10 个");
        for(int i = 0; i < 12; i++) {
            if(null == mysqlConnection.getLimitConnection()) {
                System.out.println("获得第" + (i+1) + "个数据库链接成功");
            } else {
                System.out.println("获得第" + (i+1) + "个数据库链接失败:数据库连接池已满");
            }
        }
        System.out.println("模仿开始释放 mysql 链接");
        for(int i = 0; i < 12; i++) {
            if(mysqlConnection.releaseLimitConnection()) {
                System.out.println("释放第" + (i+1) + "个数据库链接成功");
            } else {
                System.out.println("释放第" + (i+1) + "个数据库链接失败");
            }
        }
        System.out.println("模仿结束");
    }
}
