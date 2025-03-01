package com.lzy._case.service.impl;

import com.lzy._case.service.CaseTestOpenfeignService;
import com.lzy.common.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CaseTestOpenfeignServiceImpl implements CaseTestOpenfeignService {

    @Override
    public String openfeignTest(String data) {
        if (StringUtils.isNotEmpty(data) && "jdsbbmq-new-user".equals(data)) {
            return "jdsbbmq-new-case";
        } else {
            throw new RuntimeException("数据不存在");
        }
    }
}
