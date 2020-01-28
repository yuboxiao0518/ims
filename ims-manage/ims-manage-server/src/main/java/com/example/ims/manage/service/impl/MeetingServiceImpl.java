package com.example.ims.manage.service.impl;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ims.common.core.config.RedisTemplateConfig;
import com.example.ims.common.core.util.R;
import com.example.ims.manage.api.entity.TMdMeeting;
import com.example.ims.manage.mapper.MeetingMapper;
import com.example.ims.manage.service.MeetingService;
import com.example.ims.project.api.feign.RemoteConfigService;
import com.example.ims.project.api.feign.RemoteMenuService;
import com.example.ims.project.api.feign.RemoteUserService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MeetingServiceImpl extends ServiceImpl<MeetingMapper, TMdMeeting> implements MeetingService {

    private final RemoteUserService remoteUserService;

    private final RemoteMenuService remoteMenuService;

    private final RemoteConfigService remoteConfigService;

    @Override
    public String info() {
        return "yubx";
    }

    @Override
    @Cacheable(value = "meeting_details", key = "#yubx  + '_meeting'")
    public List queryMeeting() {
        return baseMapper.selectList(Wrappers.query());
    }

    @Override
    public R queryMenu(){
        return R.ok(remoteMenuService.queryMenu());
    }

    @Override
    public Boolean queryUserInfo() {
        return remoteUserService.get();
    }

    @Override
    public String getDataSource() {
        return remoteConfigService.getDataSource();
    }

    @Override
    @CacheEvict(value = "meeting_details",allEntries = true)
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    @CacheEvict(value = "meeting_details",allEntries = true)
    public boolean removeByMap(Map<String, Object> columnMap) {
        return super.removeByMap(columnMap);
    }
}
