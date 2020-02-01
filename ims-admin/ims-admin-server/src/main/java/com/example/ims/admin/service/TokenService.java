package com.example.ims.admin.service;

import com.example.ims.admin.api.entity.SysUser;
import com.example.ims.admin.dto.UserInfo;

public interface TokenService {
    public String getToken(UserInfo user);
}
