package com.lzy.user.feign;

// 使用@FeignClient注解定义一个Feign客户端，用于声明式的服务调用
//@FeignClient(
//        value = "pcmis-case", // 服务名称，用于调用具有该名称的服务
//        fallback = TestUserCaseOpenfeignHandler.class, // 熔断处理类，当调用失败时使用
//        decode404 = true // 是否解码404错误响应，默认为false。开启后，404响应将被解码成一个HystrixCommandResult
//)
//@Component // 将该接口注册为Spring的Bean，以便在应用中自动扫描和注入
public interface TestUserCaseOpenfeign {
    // 声明一个GET请求的方法，用于调用远程服务的特定接口
    // @GetMapping("/testCase/openfeignTest") // 映射GET请求到这个方法，路径为"/testCase/openfeignTest"
    // String openfeignTest(@RequestParam("data") String data); // 方法参数来自请求参数"data"，返回一个字符串类型的数据

}
