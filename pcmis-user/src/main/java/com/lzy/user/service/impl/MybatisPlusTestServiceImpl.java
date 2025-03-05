package com.lzy.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.db.UserEntity;
import com.lzy.user.dao.UserMapper;
import com.lzy.user.service.MybatisPlusTestService;
import org.springframework.stereotype.Service;

@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements MybatisPlusTestService {

}
