package com.lzy.user.service.impl;

import com.lzy.user.feign.TestUserSeataOpenFeign;
import com.lzy.user.service.UserTestOpenfeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTestOpenfeignServiceImpl implements UserTestOpenfeignService {

    private static final Logger log = LoggerFactory.getLogger(UserTestOpenfeignServiceImpl.class);

//    @Autowired
//    private TestUserCaseOpenfeign testUserCaseOpenfeign;

    @Autowired
    private TestUserSeataOpenFeign testUserSeataOpenfeign;

//    @Override
//    public String openfeignTest(String data) {
//        log.debug("openfeignTest data:{}", data);
//        return testUserCaseOpenfeign.openfeignTest(data);
//    }

    @Override
    public String seataTest(String data) {
        log.debug("seataTest data:{}", data);
        return testUserSeataOpenfeign.seataTest(data);
    }
}
