package com.lzy.risk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.db.RiskAssessmentEntity;
import com.lzy.risk.dao.RiskAssessmentMapper;
import com.lzy.risk.service.MybatisPlusTestService;
import org.springframework.stereotype.Service;

/**
 * MybatisPlus测试服务实现类
 * 该类继承了ServiceImpl，用于实现MybatisPlusTestService接口
 * 主要负责风险相关的业务逻辑处理
 */
@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<RiskAssessmentMapper, RiskAssessmentEntity> implements MybatisPlusTestService {

}
