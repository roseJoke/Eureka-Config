package com.kuliao.eureka.controller;

import com.kuliao.eureka.entity.User;
import com.kuliao.eureka.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyClass {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloConsumer(){
        return helloService.helloService();
    }


    @RequestMapping("/index")
    @HystrixCommand(fallbackMethod="helloFallback")
    public String index(){
        String results=restTemplate.getForObject("http://eureka-provider/getName",String.class);
        return results;
    }
    public String helloFallback(){
        return "error";
    }


    @RequestMapping("/getuser")
    @ResponseBody
    public User index2(){
        User user=new User(1,"didi","14234");
        //ResponseEntity<User> responseEntity=restTemplate.getForEntity("http://Eureka-Consumer/user",User.class,user);
        //User user1=responseEntity.getBody();
        System.out.println(user);
        return user;
    }
}
