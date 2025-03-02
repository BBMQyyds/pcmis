package com.lzy.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.CaseEntity;
import com.lzy.common.entity.ProjectEntity;
import com.lzy.project.dao.ProjectMapper;
import com.lzy.project.service.MybatisPlusTestService;
import org.springframework.stereotype.Service;

@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<ProjectMapper, ProjectEntity> implements MybatisPlusTestService {

}
