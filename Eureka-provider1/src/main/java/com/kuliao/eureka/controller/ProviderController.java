package com.kuliao.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @Value("${spring.application.name}")
    String appName;

    @Value("${server.port}")
    String port;

    @GetMapping("/getName")
    public String getAppName() {
        System.out.println(appName+":"+port);
        return appName+":" + port;
    }
}
