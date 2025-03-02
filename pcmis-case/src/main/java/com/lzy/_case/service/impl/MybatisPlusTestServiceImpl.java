package com.lzy._case.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy._case.dao.CaseMapper;
import com.lzy._case.service.MybatisPlusTestService;
import com.lzy.common.entity.CaseEntity;
import org.springframework.stereotype.Service;

@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<CaseMapper, CaseEntity> implements MybatisPlusTestService {

}
