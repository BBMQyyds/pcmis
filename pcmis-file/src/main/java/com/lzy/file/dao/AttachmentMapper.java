package com.lzy.file.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzy.common.entity.db.AttachmentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 案例数据访问对象(AttachmentMapper)接口
 * 该接口用于定义对案例数据库表进行操作的方法，如增删查改
 * 继承了BaseMapper，自动获得了基本的CRUD功能
 */
@Mapper
public interface AttachmentMapper extends BaseMapper<AttachmentEntity> {

}
