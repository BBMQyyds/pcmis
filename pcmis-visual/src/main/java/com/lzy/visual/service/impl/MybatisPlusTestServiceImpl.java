package com.lzy.visual.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.CaseProcessEntity;
import com.lzy.visual.dao.CaseProcessMapper;
import com.lzy.visual.service.MybatisPlusTestService;
import org.springframework.stereotype.Service;

@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<CaseProcessMapper, CaseProcessEntity> implements MybatisPlusTestService {

}
