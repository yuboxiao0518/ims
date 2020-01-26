package com.example.ims.project.api.feign;

import com.example.ims.common.core.constant.ServiceNameConstants;
import com.example.ims.common.core.util.R;
import com.example.ims.project.api.feign.factory.RemoteMenuServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(contextId = "RemoteMenuService",name = ServiceNameConstants.PROJECT_SERVICE,fallbackFactory = RemoteMenuServiceFallbackFactory.class)
public interface RemoteMenuService {

    @GetMapping("/menu/queryMenu")
    public R queryMenu();
}
