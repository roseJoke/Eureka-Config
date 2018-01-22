package com.kuliao.eureka.controller;

import com.kuliao.eureka.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getusr")
    @ResponseBody
    public User index2(){
        User user=new User(1,"didi","14234");
        //ResponseEntity<User> responseEntity=restTemplate.getForEntity("http://eureka-provider/user",User.class,user);
        //User user1=responseEntity.getBody();
        System.out.println(user);
        return user;
    }
}
