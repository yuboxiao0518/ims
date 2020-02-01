package com.example.ims.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ims.manage.api.entity.IndexPerformance;

import java.util.List;

public interface IndexPerformanceService extends IService<IndexPerformance> {

    public Boolean importIndexPerformance(String filePath);
}
