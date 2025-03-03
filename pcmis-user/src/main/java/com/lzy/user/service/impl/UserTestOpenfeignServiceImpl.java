package com.lzy.user.service.impl;

import com.lzy.user.feign.TestUserCaseOpenfeign;
import com.lzy.user.service.UserTestOpenfeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTestOpenfeignServiceImpl implements UserTestOpenfeignService {

    private static final Logger log = LoggerFactory.getLogger(UserTestOpenfeignServiceImpl.class);
    @Autowired
    private TestUserCaseOpenfeign testUserCaseOpenfeign;

    @Override
    public String openfeignTest(String data) {
        log.debug("openfeignTest data:{}", data);
        return testUserCaseOpenfeign.openfeignTest(data);
    }
}
