package com.lzy.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzy.common.entity.db.UserEntity;
import com.lzy.user.service.UserService;
import com.lzy.user.service.UserTestOpenfeignService;
import feign.FeignException;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testUser")
public class UserTestOpenfeignController {

    // 日志对象，用于记录日志信息
    private static final Logger log = LoggerFactory.getLogger(UserTestOpenfeignController.class);

    // 用户测试服务，通过 OpenFeign 调用其他服务
    @Autowired
    private UserTestOpenfeignService userTestOpenfeignService;

    // 用户服务，用于操作用户相关数据
    @Autowired
    private UserService userService;

    /**
     * 使用 Seata 进行分布式事务测试的方法
     * 该方法首先更新 admin 用户的密码，然后调用远程服务
     * 如果远程服务调用失败，将抛出异常并进行事务回滚
     *
     * @return 如果操作成功，返回 "success"
     * @throws TransactionException 如果事务操作失败，抛出该异常
     */
    @RequestMapping("/seataTest")
    @GlobalTransactional
    public String seataTest() throws TransactionException {
        try {
            // 更新 admin 用户的密码
            QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", "admin");
            UserEntity userEntity = userService.getOne(queryWrapper);
            userEntity.setPassword("654321");
            userService.updateById(userEntity);

            // 捕获 FeignException 并手动抛出 RuntimeException
            try {
                // 调用远程服务进行 Seata 测试
                System.out.println(userTestOpenfeignService.seataTest("test"));
            } catch (FeignException e) {
                // Feign 调用失败，记录日志并抛出异常，触发事务回滚
                log.error("Feign 调用失败，触发回滚", e);
                throw new RuntimeException("Feign 调用异常导致事务回滚", e);
            }

            return "success";
        } catch (Exception e) {
            // 记录异常信息，并进行事务回滚
            log.error("seataTest error", e);
            GlobalTransactionContext.reload(RootContext.getXID()).rollback();
            throw e;
        }
    }

}

