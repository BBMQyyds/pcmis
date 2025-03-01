package com.lzy.user.feign;

import org.springframework.stereotype.Component;

@Component
public class TestUserCaseOpenfeignHandler implements TestUserCaseOpenfeign {

    @Override
    public String openfeignTest(String data) {
        return "当前人数过多,休息一会再试";
    }
}
