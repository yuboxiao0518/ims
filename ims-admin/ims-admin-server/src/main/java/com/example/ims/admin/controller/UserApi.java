package com.example.ims.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ims.admin.annotation.UserLoginToken;
import com.example.ims.admin.api.entity.SysUser;
import com.example.ims.admin.dto.UserInfo;
import com.example.ims.admin.service.SysUserService;
import com.example.ims.admin.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class UserApi {

    private final SysUserService userService;

    private final TokenService tokenService;

    //登录
    @PostMapping("/login")
    public Object login(@RequestBody SysUser user) {
        JSONObject jsonObject = new JSONObject();
        UserInfo userForBase = userService.getUserInfo(user);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getSysUser().getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }
}
