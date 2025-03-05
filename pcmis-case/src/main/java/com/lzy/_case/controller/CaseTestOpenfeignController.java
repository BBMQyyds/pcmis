package com.lzy._case.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzy._case.service.CaseTestOpenfeignService;
import com.lzy._case.service.MybatisPlusTestService;
import com.lzy.common.entity.db.CaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/testCase")
public class CaseTestOpenfeignController {

    private static final Logger log = LoggerFactory.getLogger(CaseTestOpenfeignController.class);
    @Autowired
    private CaseTestOpenfeignService caseTestOpenfeignService;

    @Autowired
    private MybatisPlusTestService mybatisPlusTestService;

    @RequestMapping("/openfeignTest")
    public String openfeignTest(String data) {
        return caseTestOpenfeignService.openfeignTest(data);
    }

    @RequestMapping("/seataTest")
    public String seataTest(String data) {
        try {
            QueryWrapper<CaseEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("case_id", 1);
            CaseEntity caseEntity = mybatisPlusTestService.getOne(queryWrapper);
            caseEntity.setComplainant("complainant");
            System.out.println(1/0); // 这里抛出异常
            mybatisPlusTestService.updateById(caseEntity);
            return "success";
        } catch (Exception e) {
            log.error("seataTest error", e);
            throw new RuntimeException("Feign 调用抛出异常，触发回滚", e);
        }
    }
}
