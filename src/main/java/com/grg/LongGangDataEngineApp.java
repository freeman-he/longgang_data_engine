package com.grg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.grg.mapper")
@EnableCaching
public class LongGangDataEngineApp {

    public static void main(String[] args) {
        SpringApplication.run(LongGangDataEngineApp.class, args);
    }
}
