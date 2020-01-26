package com.example.ims.project.api.feign.factory;

import com.example.ims.project.api.feign.RemoteMenuService;
import com.example.ims.project.api.feign.fallback.RemoteMenuServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RemoteMenuServiceFallbackFactory implements FallbackFactory<RemoteMenuService> {
    @Override
    public RemoteMenuService create(Throwable throwable) {
        RemoteMenuServiceFallbackImpl remoteMenuServiceFallback = new RemoteMenuServiceFallbackImpl();
        remoteMenuServiceFallback.setCause(throwable);
        return remoteMenuServiceFallback;
    }
}
