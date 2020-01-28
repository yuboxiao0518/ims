package com.example.ims.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ims.common.core.util.R;
import com.example.ims.manage.api.entity.TMdMeeting;

import java.util.List;

public interface MeetingService extends IService<TMdMeeting> {
    public String info();

    public List<TMdMeeting> queryMeeting();

    public R queryMenu();

    public Boolean queryUserInfo();

    public String getDataSource();

}
