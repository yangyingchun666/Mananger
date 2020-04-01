package com.yyc.testredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yyc.testredis")
@MapperScan("com.yyc.testredis.mapper")
public class TestredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestredisApplication.class, args);
    }

}
