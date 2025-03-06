package com.lzy.user.service.impl;

import com.lzy.user.feign.TestUserSeataOpenFeign;
import com.lzy.user.service.UserTestOpenfeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户测试OpenFeign服务实现类
 * 该类实现了UserTestOpenfeignService接口，提供了具体的服务实现
 */
@Service
public class UserTestOpenfeignServiceImpl implements UserTestOpenfeignService {

    // 日志对象，用于记录日志信息
    private static final Logger log = LoggerFactory.getLogger(UserTestOpenfeignServiceImpl.class);

    // 注入TestUserSeataOpenFeign接口的实现，用于进行Seata分布式事务测试
    @Autowired
    private TestUserSeataOpenFeign testUserSeataOpenfeign;

    /**
     * Seata分布式事务测试方法
     * 接收一个数据字符串作为输入，记录调试日志，并调用TestUserSeataOpenFeign接口的seataTest方法进行处理
     *
     * @param data 输入的数据字符串，用于Seata分布式事务测试
     * @return 处理结果字符串
     */
    @Override
    public String seataTest(String data) {
        log.debug("seataTest data:{}", data);
        return testUserSeataOpenfeign.seataTest(data);
    }
}
