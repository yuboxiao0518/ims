package com.example.ims.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/config/")
@Slf4j
public class ConfigController {
    @Value(value = "${useLocalCache:false}")
    private boolean useLocalCache;

    @Value(value = "spring: datasource:yubx")
    private String datasource;

    @GetMapping("get")
    public boolean get() {
        return useLocalCache;
    }

    @GetMapping("datasource")
    public String getDataSource() {
        String bb=null;
        bb.toString();
        return datasource;
    }
}
