package com.nanpu.nanpueuraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NanpuEurakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NanpuEurakaApplication.class, args);
    }

}
