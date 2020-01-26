package com.example.ims.project.api.feign;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
@Slf4j
@AllArgsConstructor
@RunWith(SpringJUnit4ClassRunner.class)
public class RemoteUserServiceTest {
    private final RemoteUserService remoteUserService;

    @Test
    public void info() {
       log.info("yubx");
    }
}