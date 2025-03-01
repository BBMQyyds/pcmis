package com.lzy.security.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/security1")
public class HelloWorldController {

    @Value("${pcmis-security.test.admin}")
    private String admin;

    @GetMapping("/getUserConfigTest")
    public String getUserConfigTest() {
        return admin != null ? admin : "未获取到配置信息";
    }

}
