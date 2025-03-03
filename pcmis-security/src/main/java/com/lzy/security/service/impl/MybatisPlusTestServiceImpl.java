package com.lzy.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.SmsCodeEntity;
import com.lzy.security.dao.SmsCodeMapper;
import com.lzy.security.service.MybatisPlusTestService;
import org.springframework.stereotype.Service;

@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<SmsCodeMapper, SmsCodeEntity> implements MybatisPlusTestService {

}
