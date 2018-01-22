package com.kuliao.eurek.controller;

import com.kuliao.eurek.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyClass {

    @Autowired
    private RestTemplate restTemplate;





    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        String results=restTemplate.getForObject("http://eureka-provider/getName",String.class);
        return results;
    }

    @RequestMapping("/index1")
    @ResponseBody
    public String index1(){
        String result=restTemplate.getForObject("http://eureka-provider/getusr",String.class);
        return result;
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
