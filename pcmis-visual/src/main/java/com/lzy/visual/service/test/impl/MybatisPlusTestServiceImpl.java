package com.lzy.visual.service.test.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.db.StatReportEntity;
import com.lzy.visual.dao.StatReportMapper;
import com.lzy.visual.service.test.MybatisPlusTestService;
import org.springframework.stereotype.Service;

/**
 * MybatisPlus测试服务实现类
 * 该类继承了ServiceImpl，用于实现MybatisPlusTestService接口
 * 主要负责可视化相关的业务逻辑处理
 */
@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<StatReportMapper, StatReportEntity> implements MybatisPlusTestService {

}
