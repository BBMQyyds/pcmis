package com.lzy.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzy.common.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
