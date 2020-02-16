package com.citydo.quwh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.citydo.lcl.dao")
public class QuwhApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuwhApplication.class, args);
    }

}
