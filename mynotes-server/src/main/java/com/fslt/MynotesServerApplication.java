package com.fslt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.fslt.dao")
public class MynotesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MynotesServerApplication.class, args);
    }

}
