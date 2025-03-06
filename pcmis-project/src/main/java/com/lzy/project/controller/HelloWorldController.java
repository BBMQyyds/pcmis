package com.lzy.project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 使用@RefreshScope注解，使该控制器支持Spring Cloud配置刷新功能
@RefreshScope
// 使用@RestController注解，标识该类为一个RESTful风格的控制器
@RestController
// 使用@RequestMapping注解，指定该控制器处理的URL路径前缀为"/project1"
@RequestMapping("/project1")
public class HelloWorldController {

    // 使用@Value注解，从配置中心获取"pcmis-project.test.admin"配置项的值
    @Value("${pcmis-project.test.admin}")
    private String admin;

    // 定义一个GET类型的RESTful接口，处理"/project1/getUserConfigTest"的HTTP GET请求
    @GetMapping("/getUserConfigTest")
    public String getUserConfigTest() {
        // 如果获取到了配置信息，则返回该信息；否则返回提示信息"未获取到配置信息"
        return admin != null ? admin : "未获取到配置信息";
    }

}

