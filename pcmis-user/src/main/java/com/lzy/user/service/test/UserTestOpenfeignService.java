package com.lzy.user.service.test;

/**
 * UserTestOpenfeignService接口用于定义跨服务调用的Feign客户端方法
 * 主要用于微服务架构中服务与服务之间的通信
 */
public interface UserTestOpenfeignService {

    /**
     * 使用OpenFeign进行Seata事务测试的方法
     * 此方法接收一个字符串参数data，并返回一个字符串结果
     * 主要用于测试在分布式事务中，服务间的交互是否正常
     *
     * @param data 分布式事务测试中传递的数据
     * @return 返回事务测试的结果信息
     */
    String seataTest(String data);
}

