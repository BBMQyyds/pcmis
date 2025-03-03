package com.lzy.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzy.common.entity.UserEntity;

public interface UserService extends IService<UserEntity> {
    UserEntity login(String username, String password);
}
