package com.example.ims.project.api.feign.fallback;

import com.example.ims.common.core.util.R;
import com.example.ims.project.api.feign.RemoteMenuService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class RemoteMenuServiceFallbackImpl implements RemoteMenuService {

    @Setter
    private Throwable cause;

    @Override
    public R queryMenu() {
        log.error("queryMenu :"+cause);
        log.error("-----------------------------------------------------------");
        return null;
    }
}
