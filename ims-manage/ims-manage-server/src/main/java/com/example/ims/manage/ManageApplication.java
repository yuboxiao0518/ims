package com.example.ims.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@SpringCloudApplication
@EnableCaching
@EnableFeignClients(basePackages = {"com.example.ims.project.api"})
@MapperScan("com.example.ims.manage.mapper")
public class ManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class,args);
    }
}
