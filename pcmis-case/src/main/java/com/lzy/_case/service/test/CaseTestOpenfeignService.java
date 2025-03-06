package com.lzy._case.service.test;

/**
 * CaseTestOpenfeignService接口用于定义对外提供的服务接口
 * 主要用途是通过OpenFeign进行服务间的调用
 */
public interface CaseTestOpenfeignService {
    /**
     * 调用此方法以执行OpenFeign测试
     * 此方法接收一个字符串参数data，该参数代表测试数据
     *
     * @param data 测试数据，可以是任何字符串
     * @return 返回一个字符串，表示测试的结果
     */
    String openfeignTest(String data);
}
