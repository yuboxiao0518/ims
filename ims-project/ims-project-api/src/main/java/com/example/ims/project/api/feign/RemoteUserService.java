package com.example.ims.project.api.feign;

import cn.hutool.system.UserInfo;
import com.example.ims.common.core.constant.ServiceNameConstants;
import com.example.ims.common.core.util.R;
import com.example.ims.project.api.feign.factory.RemoteUserServiceFallbackFactory;
import com.example.ims.project.api.feign.fallback.RemoteUserServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(contextId ="RemoteUserService",value=ServiceNameConstants.PROJECT_SERVICE,fallback = RemoteUserServiceFallbackImpl.class)
public interface RemoteUserService {

    @RequestMapping(method = RequestMethod.GET, value = "/user/info")
    public R<UserInfo> info();
}
