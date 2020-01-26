package com.example.ims.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/config")
@Slf4j
public class ConfigController {
    @Value(value = "${useLocalCache:false}")
    private boolean useLocalCache;
    @Value(value = "${datasource.type:yubx}")
    private String type;

    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }
}
