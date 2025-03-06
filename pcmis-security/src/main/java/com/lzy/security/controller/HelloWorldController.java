package com.lzy.security.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 使用@RefreshScope注解，使该控制器支持Spring Cloud配置刷新功能
@RefreshScope
// 使用@RestController注解，表明这是一个RESTful风格的控制器
@RestController
// 使用@RequestMapping注解，指定该控制器处理的URL路径前缀为"/security1"
@RequestMapping("/security1")
public class HelloWorldController {

    // 使用@Value注解，从配置中心获取名为"pcmis-security.test.admin"的配置项值
    @Value("${pcmis-security.test.admin}")
    private String admin;

    // 定义一个GET请求的处理方法，用于获取用户配置测试信息
    @GetMapping("/getUserConfigTest")
    public String getUserConfigTest() {
        // 如果获取到了配置信息，则返回该信息；否则返回默认提示信息"未获取到配置信息"
        return admin != null ? admin : "未获取到配置信息";
    }

}

