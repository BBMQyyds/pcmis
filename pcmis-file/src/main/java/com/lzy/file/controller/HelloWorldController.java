package com.lzy.file.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 使用@RefreshScope注解，使该控制器支持Spring Cloud配置刷新功能
@RefreshScope
// 使用@RestController注解，标识该类为一个RESTful风格的控制器
@RestController
// 使用@RequestMapping注解，指定该控制器处理的URL路径为"/file1"
@RequestMapping("/file1")
public class HelloWorldController {

    // 使用@Value注解，从配置文件中注入名为"pcmis-file.test.admin"的属性值到admin变量
    @Value("${pcmis-file.test.admin}")
    private String admin;

    // 使用@GetMapping注解，指定该方法处理GET请求，路径为"/getUserConfigTest"
    @GetMapping("/getUserConfigTest")
    // 方法getUserConfigTest用于返回配置信息中的admin字段值，如果没有配置则返回默认信息
    public String getUserConfigTest() {
        // 判断admin变量是否不为空，如果不为空则返回admin变量的值，否则返回默认信息"未获取到配置信息"
        return admin != null ? admin : "未获取到配置信息";
    }

}

