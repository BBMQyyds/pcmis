package com.lzy.user.service.test.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.db.UserEntity;
import com.lzy.user.dao.UserMapper;
import com.lzy.user.service.test.MybatisPlusTestService;
import org.springframework.stereotype.Service;

/**
 * MybatisPlus测试服务实现类
 * 该类继承了ServiceImpl，用于实现MybatisPlusTestService接口
 * 主要负责用户相关的业务逻辑处理
 */
@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements MybatisPlusTestService {

}

