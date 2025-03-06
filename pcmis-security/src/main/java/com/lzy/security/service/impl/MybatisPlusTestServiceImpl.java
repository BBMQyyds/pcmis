package com.lzy.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.db.SmsCodeEntity;
import com.lzy.security.dao.SmsCodeMapper;
import com.lzy.security.service.MybatisPlusTestService;
import org.springframework.stereotype.Service;

/**
 * MybatisPlus测试服务实现类
 * 该类继承了ServiceImpl，用于实现MybatisPlusTestService接口
 * 主要负责安全相关的业务逻辑处理
 */
@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<SmsCodeMapper, SmsCodeEntity> implements MybatisPlusTestService {

}
