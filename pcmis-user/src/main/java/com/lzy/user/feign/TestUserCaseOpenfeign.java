package com.lzy.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "pcmis-case",
        fallback = TestUserCaseOpenfeignHandler.class,
        decode404 = true
)
@Component
public interface TestUserCaseOpenfeign {

    @GetMapping("/testCase/openfeignTest")
    String openfeignTest(@RequestParam("data") String data);

    @GetMapping("/testCase/seataTest")
    String seataTest(@RequestParam("data") String data);
}
