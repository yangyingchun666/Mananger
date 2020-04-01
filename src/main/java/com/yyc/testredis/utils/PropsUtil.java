package com.yyc.testredis.utils;


import cn.hutool.setting.dialect.Props;

public class PropsUtil {

    static Props applicationProps = new Props("application.properties");

    public static String getProperty(String key){
        return applicationProps.getStr(key);
    }

}
