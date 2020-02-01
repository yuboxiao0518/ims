package com.example.ims.manage.service.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ims.manage.api.entity.IndexPerformance;
import com.example.ims.manage.mapper.IndexPerformanceMapper;
import com.example.ims.manage.service.IndexPerformanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexPerformanceServiceImpl extends ServiceImpl<IndexPerformanceMapper, IndexPerformance> implements IndexPerformanceService {

    @Override
    public Boolean importIndexPerformance(String filePath) {
        ExcelReader reader = ExcelUtil.getReader(filePath);
        List<IndexPerformance> all = reader.readAll(IndexPerformance.class);
        boolean b = saveBatch(all);
        return b;
    }
}
