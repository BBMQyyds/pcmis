package com.lzy.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 定义一个Feign客户端，用于调用名称为"pcmis-case"的服务
// 当返回404错误时，进行解码处理，避免抛出异常
@FeignClient(
        value = "pcmis-case",
        decode404 = true
)
// 标记为Spring组件，使其被自动扫描和管理
@Component
public interface TestUserSeataOpenFeign {

    // 定义一个GET请求的映射，用于调用服务中的/seataTest端点
    // 参数"data"将在请求中作为查询参数传递
    // 返回值为String类型，包含从服务端响应的数据
    @GetMapping("/testCase/seataTest")
    String seataTest(@RequestParam("data") String data);
}

