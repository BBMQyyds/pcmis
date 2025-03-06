package com.lzy.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.common.entity.db.UserEntity;
import com.lzy.user.dao.UserMapper;
import com.lzy.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 * 继承自ServiceImpl，用于处理用户相关的业务逻辑
 * 选择继承ServiceImpl是因为它提供了基本的CRUD操作，可以减少重复代码，提高开发效率
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}



