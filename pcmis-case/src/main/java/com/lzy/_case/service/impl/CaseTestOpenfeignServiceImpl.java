package com.lzy._case.service.impl;

import com.lzy._case.service.CaseTestOpenfeignService;
import com.lzy.common.util.StringUtils;
import org.springframework.stereotype.Service;

/**
 * CaseTestOpenfeignService的实现类
 * 提供开放服务接口的实现，用于处理特定数据并返回相应的结果
 */
@Service
public class CaseTestOpenfeignServiceImpl implements CaseTestOpenfeignService {

    /**
     * 根据输入的数据返回相应的字符串
     *
     * @param data 输入的数据，用于判断返回值
     * @return 如果输入数据为"jdsbbmq-new-user"，则返回"jdsbbmq-new-case"，否则抛出运行时异常
     * @throws RuntimeException 如果输入数据为空或不符合预期，抛出运行时异常
     */
    @Override
    public String openfeignTest(String data) {
        // 检查输入数据是否不为空且是否等于预期值
        if (StringUtils.isNotEmpty(data) && "jdsbbmq-new-user".equals(data)) {
            // 返回预期的结果字符串
            return "jdsbbmq-new-case";
        } else {
            // 如果输入数据不符合预期，抛出运行时异常
            throw new RuntimeException("数据不存在");
        }
    }
}
