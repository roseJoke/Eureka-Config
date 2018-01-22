package com.kuliao.eureka.controller;

import com.kuliao.eureka.entity.User;


import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.logging.Logger;


@RestController
public class ProviderController {
    @Value("${spring.application.name}")
    String appName;

    @Value("${server.port}")
    String port;


    Logger logger=Logger.getLogger("logger1");

    @GetMapping("/hh")
    public String getAppNamaaae() throws Exception{
        int sleepTime=new Random().nextInt(10);

        logger.info(" sleepTime:"+sleepTime);
        Thread.sleep(sleepTime);
        System.out.println(appName+":"+port);
        return appName+":" + port+"                 来自feign的负载均衡！";
    }
    @GetMapping("/getName")
    public String getAppName() {
        System.out.println(appName+":"+port);
        return appName+":" + port;
    }
    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/hello")
    public String hello() {
        return "error11";
    }
    @RequestMapping(value="/hello1",method= RequestMethod.GET)
    public String hello(String name) {
        return "error22";
    }
    @RequestMapping(value="/hello2",method=RequestMethod.GET)
    public User hello(Long id, String username) {
        return new User(12,"未知");
    }
    @RequestMapping(value="/hello3",method=RequestMethod.GET)
    public String hello(User user) {
        return "Error33";
    }


    @GetMapping("/getusr")
    @ResponseBody
    public User index2(){
        User user=new User(1,"didi");
        //ResponseEntity<User> responseEntity=restTemplate.getForEntity("http://eureka-provider/user",User.class,user);
        //User user1=responseEntity.getBody();
        System.out.println(user);
        return user;
    }
}
