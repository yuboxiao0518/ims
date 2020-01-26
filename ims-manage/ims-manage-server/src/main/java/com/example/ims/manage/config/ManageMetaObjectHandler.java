package com.example.ims.manage.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Configuration
public class ManageMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createDate", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject,"meetingName",String.class,"公司会议");
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
