package com.example.ims.admin.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.ims.admin.api.entity.SysUser;
import com.example.ims.admin.dto.UserInfo;
import com.example.ims.admin.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(UserInfo user) {
        String token = "";
        token = JWT.create().withAudience(user.getSysUser().getUserId().toString())
                .sign(Algorithm.HMAC256(user.getSysUser().getPassword()));
        return token;
    }
}
