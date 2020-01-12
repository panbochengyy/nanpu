package com.gz.nanpu.nanpuservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;



//@EnableDiscoveryClient
@EnableEurekaServer //注解支持
@MapperScan("com.gz.nanpu.nanpuservice") //扫描的mapper
@SpringBootApplication
public class Zapplication {
    public static void main(String[] args) {
        SpringApplication.run(Zapplication.class, args);
    }
}
