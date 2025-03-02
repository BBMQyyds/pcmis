package com.lzy._case.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzy._case.service.MybatisPlusTestService;
import com.lzy.common.entity.CaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/testmp")
public class MybatisPlusTestController {

    @Autowired
    private MybatisPlusTestService mybatisPlusTestService;

    @RequestMapping("/test")
    public Map<String, Object> MPTest() {
        // 初始化返回类
        Map<String, Object> result = new HashMap<>();

        // 查询案件表：所有"待受理"状态的案件
        QueryWrapper<CaseEntity> caseQueryWrapper = new QueryWrapper<>();
        caseQueryWrapper.lambda().eq(CaseEntity::getCurrentStatus, "待受理");
        List<CaseEntity> caseList = mybatisPlusTestService.list(caseQueryWrapper);
        result.put("caseList", caseList);

        // 查询所有案件的案件类别为"工程建设"的案件
        QueryWrapper<CaseEntity> caseTypeQueryWrapper = new QueryWrapper<>();
        caseTypeQueryWrapper.lambda().eq(CaseEntity::getCaseType, "工程建设");
        List<CaseEntity> caseTypeList = mybatisPlusTestService.list(caseTypeQueryWrapper);
        result.put("caseTypeList", caseTypeList);

        return result;
    }
}
