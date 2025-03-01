package com.lzy.user.service.impl;

import com.lzy.user.feign.TestUserCaseOpenfeign;
import com.lzy.user.service.UserTestOpenfeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTestOpenfeignServiceImpl implements UserTestOpenfeignService {

    @Autowired
    private TestUserCaseOpenfeign testUserCaseOpenfeign;

    @Override
    public String openfeignTest(String data) {
        System.out.println(data);
        return testUserCaseOpenfeign.openfeignTest(data);
    }
}
