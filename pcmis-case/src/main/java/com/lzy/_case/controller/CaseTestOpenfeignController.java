package com.lzy._case.controller;

import com.lzy._case.service.CaseTestOpenfeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/testCase")
public class CaseTestOpenfeignController {

    @Autowired
    private CaseTestOpenfeignService caseTestOpenfeignService;

    @RequestMapping("/openfeignTest")
    public String openfeignTest(String data) {
        return caseTestOpenfeignService.openfeignTest(data);
    }
}
