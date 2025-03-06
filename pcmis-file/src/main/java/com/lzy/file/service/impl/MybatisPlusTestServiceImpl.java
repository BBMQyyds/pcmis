package com.lzy.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.db.AttachmentEntity;
import com.lzy.file.dao.AttachmentMapper;
import com.lzy.file.service.MybatisPlusTestService;
import org.springframework.stereotype.Service;

/**
 * MybatisPlus测试服务实现类
 * 该类继承了ServiceImpl，用于实现MybatisPlusTestService接口
 * 主要负责文件相关的业务逻辑处理
 */
@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<AttachmentMapper, AttachmentEntity> implements MybatisPlusTestService {

}
