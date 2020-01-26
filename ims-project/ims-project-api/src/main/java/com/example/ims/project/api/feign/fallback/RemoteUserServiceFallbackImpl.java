package com.example.ims.project.api.feign.fallback;

import cn.hutool.system.UserInfo;
import com.example.ims.common.core.util.R;
import com.example.ims.project.api.feign.RemoteUserService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RemoteUserServiceFallbackImpl implements RemoteUserService {
    @Setter
    private Throwable cause;

    @Override
    public R<UserInfo> info() {
        log.error("------------------------------------------------------------");
        return R.failed("失败");
    }
}
