package com.lzy.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 使用@RefreshScope注解，使该控制器支持Spring Cloud配置刷新功能
@RefreshScope
// 使用@RestController注解，标识该类为一个RESTful风格的控制器
@RestController
// 使用@RequestMapping注解，指定该控制器处理的URL路径前缀为"/user1"
@RequestMapping("/user1")
public class HelloWorldController {

    // 使用@Value注解，从配置文件中注入名为"pcmis-user.test.admin"的属性值到admin变量
    @Value("${pcmis-user.test.admin}")
    private String admin;

    // 使用@GetMapping注解，指定该方法处理GET请求，路径为"/getUserConfigTest"
    @GetMapping("/getUserConfigTest")
    // 方法返回一个字符串，如果admin变量不为空则返回其值，否则返回"未获取到配置信息"
    public String getUserConfigTest() {
        return admin != null ? admin : "未获取到配置信息";
    }

}

