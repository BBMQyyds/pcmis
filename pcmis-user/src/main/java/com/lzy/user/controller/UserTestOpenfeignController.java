package com.lzy.user.controller;

import com.lzy.user.service.UserTestOpenfeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testUser")
public class UserTestOpenfeignController {

    @Autowired
    private UserTestOpenfeignService userTestOpenfeignService;

    @RequestMapping("/openfeignTest")
    public String openfeignTest(String data) {
        return userTestOpenfeignService.openfeignTest(data);
    }
}
