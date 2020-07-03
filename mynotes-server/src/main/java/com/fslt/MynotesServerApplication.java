package com.fslt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan(basePackages = "com.fslt.dao")
@EnableAsync
public class MynotesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MynotesServerApplication.class, args);
    }

}
