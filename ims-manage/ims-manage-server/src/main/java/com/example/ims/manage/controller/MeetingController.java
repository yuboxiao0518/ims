package com.example.ims.manage.controller;

import com.example.ims.common.core.util.R;
import com.example.ims.manage.api.entity.TMdMeeting;
import com.example.ims.manage.service.MeetingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class MeetingController {
    private final MeetingService meetingService;

    @GetMapping("meeting")
    public R GetUserInfo(){
        return R.ok(meetingService.queryMeeting());
    }

    @GetMapping("hello")
    public R hello(){
        return R.ok(meetingService.queryMenu());
    }

    @GetMapping("save")
    public R saveMeeting(){
        TMdMeeting tMdMeeting = new TMdMeeting();
        tMdMeeting.setCreateUser("yubx");
        boolean save = meetingService.save(tMdMeeting);
        return R.ok(save);
    }
    @GetMapping("remove")
    public R removeMeetingMap(@RequestParam String name){
        boolean b = meetingService.removeByMap((Map<String, Object>) new HashMap<>().put("meeting_name",name));
        return R.ok(b);
    }

    @GetMapping("queryUserInfo")
    public Boolean queryUserInfo(){
        return meetingService.queryUserInfo();
    }

    @GetMapping("getDataSource")
    public String getDataSource(){
        return meetingService.getDataSource();
    }
}
