package com.lzy.risk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.CaseEntity;
import com.lzy.risk.dao.CaseMapper;
import com.lzy.risk.service.MybatisPlusTestService;
import org.springframework.stereotype.Service;

@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<CaseMapper, CaseEntity> implements MybatisPlusTestService {

}
