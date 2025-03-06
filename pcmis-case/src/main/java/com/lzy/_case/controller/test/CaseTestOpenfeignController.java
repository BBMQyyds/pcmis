package com.lzy._case.controller.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzy._case.service.test.CaseTestOpenfeignService;
import com.lzy._case.service.test.MybatisPlusTestService;
import com.lzy.common.entity.db.CaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CaseTestOpenfeignController 控制器负责处理与测试相关的请求，包括 OpenFeign 和 Seata 分布式事务测试
 */
@RestController
@RequestMapping("/testCase")
public class CaseTestOpenfeignController {

    // 日志对象，用于记录日志信息
    private static final Logger log = LoggerFactory.getLogger(CaseTestOpenfeignController.class);

    // CaseTestOpenfeignService 服务对象，用于处理 OpenFeign 调用
    @Autowired
    private CaseTestOpenfeignService caseTestOpenfeignService;

    // MybatisPlusTestService 服务对象，用于处理 MyBatis-Plus 相关的数据库操作
    @Autowired
    private MybatisPlusTestService mybatisPlusTestService;

    /**
     * openfeignTest 方法用于测试 OpenFeign 的调用
     * @param data 传递给 OpenFeign 接口的数据
     * @return 从 OpenFeign 接口返回的响应数据
     */
    @RequestMapping("/openfeignTest")
    public String openfeignTest(String data) {
        return caseTestOpenfeignService.openfeignTest(data);
    }

    /**
     * seataTest 方法用于测试 Seata 分布式事务
     * @param data 请求参数，本例中未使用
     * @return 如果操作成功，返回 "success"
     * @throws RuntimeException 如果在分布式事务中抛出异常，则抛出运行时异常
     */
    @RequestMapping("/seataTest")
    public String seataTest(String data) {
        try {
            // 创建查询包装器，用于查询 case_id 为 1 的 CaseEntity 记录
            QueryWrapper<CaseEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("case_id", 1);
            CaseEntity caseEntity = mybatisPlusTestService.getOne(queryWrapper);

            // 更新实体的投诉人字段为 "complainant"
            caseEntity.setComplainant("complainant");

            // 这里可以添加业务逻辑，例如：更新数据库
            mybatisPlusTestService.updateById(caseEntity);

            return "success";
        } catch (Exception e) {
            // 记录错误日志
            log.error("seataTest error", e);

            // 抛出自定义运行时异常，提示 Feign 调用异常并触发事务回滚
            throw new RuntimeException("Feign 调用抛出异常，触发回滚", e);
        }
    }
}
