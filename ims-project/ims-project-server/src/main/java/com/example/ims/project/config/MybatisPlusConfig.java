package com.example.ims.project.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@MapperScan("com.example.ims.project.mapper")
public class MybatisPlusConfig {
   
}
