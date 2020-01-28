package com.example.ims.project.api.feign;

import com.example.ims.common.core.constant.ServiceNameConstants;
import com.example.ims.project.api.feign.factory.RemoteConfigServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(contextId = "RemoteConfigService",name = ServiceNameConstants.PROJECT_SERVICE,fallbackFactory = RemoteConfigServiceFallbackFactory.class)
public interface RemoteConfigService {

    @GetMapping("/config/datasource")
    public String getDataSource();
}
