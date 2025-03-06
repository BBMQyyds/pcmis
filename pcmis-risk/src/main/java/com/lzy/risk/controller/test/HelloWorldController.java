package com.lzy.risk.controller.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 使用@RefreshScope注解，使该控制器支持Spring Cloud配置刷新功能
@RefreshScope
// 使用@RestController注解，标识该类为一个RESTful风格的控制器
@RestController
// 使用@RequestMapping注解，指定该控制器处理的URL路径前缀为"/risk1"
@RequestMapping("/risk1")
public class HelloWorldController {

    // 使用@Value注解，从配置文件中获取"pcmis-risk.test.admin"配置项的值
    @Value("${pcmis-risk.test.admin}")
    private String admin;

    // 定义一个GET类型的RESTful接口，处理"/getUserConfigTest"路径的请求
    @GetMapping("/getUserConfigTest")
    public String getUserConfigTest() {
        // 返回从配置文件中获取的admin值，如果未获取到，则返回默认提示信息
        return admin != null ? admin : "未获取到配置信息";
    }

}

