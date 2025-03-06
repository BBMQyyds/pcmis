package com.lzy._case.controller.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用@RefreshScope注解，使该控制器支持Spring Cloud的配置刷新功能
 * 这意味着当配置中心的配置发生变化时，该控制器的配置可以自动更新
 */
@RefreshScope
@RestController
@RequestMapping("/case1")
public class HelloWorldController {

    /**
     * 通过@Value注解注入配置中心的配置项
     * 这里的${pcmis-case.test.admin}是从配置中心获取的配置值
     */
    @Value("${pcmis-case.test.admin}")
    private String admin;

    /**
     * 获取用户配置测试信息的API接口
     *
     * @return 返回从配置中心获取的admin配置值，如果没有获取到，则返回默认信息"未获取到配置信息"
     */
    @GetMapping("/getUserConfigTest")
    public String getUserConfigTest() {
        return admin != null ? admin : "未获取到配置信息";
    }

}
