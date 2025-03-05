package com.lzy.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "pcmis-case",
        decode404 = true
)
@Component
public interface TestUserSeataOpenFeign {

    @GetMapping("/testCase/seataTest")
    String seataTest(@RequestParam("data") String data);
}
