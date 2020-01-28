package com.example.ims.project.api.feign.fallback;

import cn.hutool.system.UserInfo;
import com.example.ims.common.core.util.R;
import com.example.ims.project.api.feign.RemoteUserService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteUserServiceFallbackImpl implements RemoteUserService {
    @Setter
    private Throwable cause;

    @Override
    public R info() {
        log.error("------------------------------------------------------------");
        return R.failed("请查看网络yuxb:{}"+cause,"失败");
    }

    @Override
    public boolean get() {
        log.error("请求失败");
        return false;
    }
}
