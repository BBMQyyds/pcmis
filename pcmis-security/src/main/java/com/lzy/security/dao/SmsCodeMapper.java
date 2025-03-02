package com.lzy.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzy.common.entity.SmsCodeEntity;
import com.lzy.common.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsCodeMapper extends BaseMapper<SmsCodeEntity> {

}
