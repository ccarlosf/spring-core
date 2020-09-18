package com.ccarlos.edu.utils;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author 应癫
 */
public class DruidUtils {

    private DruidUtils(){
    }

    private static DruidDataSource druidDataSource = new DruidDataSource();


    static {
//        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        druidDataSource.setUrl("jdbc:mysql://localhost:3306/bank");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/bank?useSSL=false&serverTimezone=UTC");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("qweqwe");

    }

    public static DruidDataSource getInstance() {
        return druidDataSource;
    }

}
