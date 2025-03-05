package com.lzy.user.feign;

import org.springframework.stereotype.Component;

@Component
public class TestUserCaseOpenfeignHandler implements TestUserCaseOpenfeign {

    @Override
    public String openfeignTest(String data) {
        return "请检查数据是否正确";
    }

    @Override
    public String seataTest(String data) {
        return "请检查事务是否正常";
    }
}
