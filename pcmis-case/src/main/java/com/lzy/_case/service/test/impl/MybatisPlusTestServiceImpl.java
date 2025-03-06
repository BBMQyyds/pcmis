package com.lzy._case.service.test.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy._case.dao.CaseMapper;
import com.lzy._case.service.test.MybatisPlusTestService;
import com.lzy.common.entity.db.CaseEntity;
import org.springframework.stereotype.Service;

/**
 * Mybatis-Plus测试服务实现类
 * 该类继承了ServiceImpl，用于实现Mybatis-Plus的CRUD操作
 * 主要是为了利用Mybatis-Plus的自动代码生成和便捷的数据库操作功能
 */
@Service
public class MybatisPlusTestServiceImpl extends ServiceImpl<CaseMapper, CaseEntity> implements MybatisPlusTestService {

}
