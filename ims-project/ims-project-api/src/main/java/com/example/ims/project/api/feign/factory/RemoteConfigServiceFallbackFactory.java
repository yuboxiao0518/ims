package com.example.ims.project.api.feign.factory;

import com.example.ims.project.api.feign.RemoteConfigService;
import com.example.ims.project.api.feign.fallback.RemoteConfigServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RemoteConfigServiceFallbackFactory implements FallbackFactory<RemoteConfigService> {
    @Override
    public RemoteConfigService create(Throwable throwable) {
        RemoteConfigServiceFallbackImpl remoteConfigServiceFallback=new RemoteConfigServiceFallbackImpl();
        remoteConfigServiceFallback.setCause(throwable);
        return remoteConfigServiceFallback;
    }
}
