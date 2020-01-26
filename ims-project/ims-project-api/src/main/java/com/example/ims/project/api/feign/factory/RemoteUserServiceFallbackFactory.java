package com.example.ims.project.api.feign.factory;

import com.example.ims.project.api.feign.RemoteUserService;
import com.example.ims.project.api.feign.fallback.RemoteUserServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RemoteUserServiceFallbackFactory implements FallbackFactory<RemoteUserService> {
    @Override
    public RemoteUserService create(Throwable throwable) {
        RemoteUserServiceFallbackImpl remoteUserServiceFallback = new RemoteUserServiceFallbackImpl();
        remoteUserServiceFallback.setCause(throwable);
        return remoteUserServiceFallback;
    }
}
