package com.lzy.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.AttachmentEntity;
import com.lzy.common.entity.CaseEntity;
import com.lzy.file.dao.AttachmentMapper;
import com.lzy.file.service.MybatisPlusTestService;
import org.springframework.stereotype.Service;

@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<AttachmentMapper, AttachmentEntity> implements MybatisPlusTestService {

}
