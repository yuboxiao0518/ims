package com.example.ims.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableCaching
@EnableFeignClients
@MapperScan("com.example.ims.project.mapper")
public class ImsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImsProjectApplication.class, args);
    }

}
