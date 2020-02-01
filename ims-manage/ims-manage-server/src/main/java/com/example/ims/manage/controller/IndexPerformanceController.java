package com.example.ims.manage.controller;

import com.example.ims.common.core.util.R;
import com.example.ims.manage.service.IndexPerformanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/index")
public class IndexPerformanceController {

    private final IndexPerformanceService indexPerformanceService;

    @GetMapping("/importIndexPerformance")
    public R importIndexPerformance(){
        String filePath="C:\\Users\\13700\\PycharmProjects\\untitled\\yubx.xlsx";
        Boolean aBoolean = indexPerformanceService.importIndexPerformance(filePath);
        return R.ok(aBoolean);
    }

    @GetMapping("/get")
    public R hello(){
        return R.ok(indexPerformanceService.list());
    }
}
