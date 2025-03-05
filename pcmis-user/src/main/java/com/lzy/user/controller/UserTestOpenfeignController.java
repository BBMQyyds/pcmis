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

    private static final Logger log = LoggerFactory.getLogger(UserTestOpenfeignController.class);
    @Autowired
    private UserTestOpenfeignService userTestOpenfeignService;

    @Autowired
    private UserService userService;

    @RequestMapping("/openfeignTest")
    public String openfeignTest(String data) {
        return userTestOpenfeignService.openfeignTest(data);
    }

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
                userTestOpenfeignService.seataTest("test");
            } catch (FeignException e) {
                log.error("Feign 调用失败，触发回滚", e);
                throw new RuntimeException("Feign 调用异常导致事务回滚", e);
            }

            return "success";
        } catch (Exception e) {
            log.error("seataTest error", e);
            GlobalTransactionContext.reload(RootContext.getXID()).rollback();
            throw e;
        }
    }

}
