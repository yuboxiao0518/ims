package com.example.ims.project.api.feign;

import cn.hutool.system.UserInfo;
import com.example.ims.common.core.constant.ServiceNameConstants;
import com.example.ims.common.core.util.R;
import com.example.ims.project.api.feign.factory.RemoteUserServiceFallbackFactory;
import com.example.ims.project.api.feign.fallback.RemoteUserServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(contextId ="RemoteUserService",value=ServiceNameConstants.PROJECT_SERVICE,fallbackFactory = RemoteUserServiceFallbackFactory.class)
public interface RemoteUserService {

    @GetMapping(value = "/user/info")
    public R info();

    @GetMapping("/config/get")
    public boolean get();
}
