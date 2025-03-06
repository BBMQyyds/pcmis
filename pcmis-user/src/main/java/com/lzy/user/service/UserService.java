package com.lzy.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzy.common.entity.db.UserEntity;

/**
 * MybatisPlusTestService接口扩展了IService，专门用于处理UserEntity实体的业务逻辑
 * 该接口利用MyBatis-Plus框架提供的IService泛型接口，实现了对UserEntity实体的基本CRUD操作
 * 主要目的是为了减少重复的模板代码，提高开发效率，并且利用MyBatis-Plus的强大功能简化数据访问层的实现
 */
public interface UserService extends IService<UserEntity> {
}
