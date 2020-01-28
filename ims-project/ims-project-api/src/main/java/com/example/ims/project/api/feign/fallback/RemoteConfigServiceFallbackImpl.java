package com.example.ims.project.api.feign.fallback;

import com.example.ims.project.api.feign.RemoteConfigService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteConfigServiceFallbackImpl implements RemoteConfigService{

    @Setter
    private Throwable cause;

    @Override
    public String getDataSource() {
        log.info("错误信息："+cause.getMessage());
        return "获取数据源失败";
    }
}
