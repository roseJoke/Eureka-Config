package com.kuliao.eurek.controller;


import com.kuliao.eurek.entity.User;
import com.kuliao.eurek.infeign.HelloServiceFallback;
import com.kuliao.eurek.infeign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
   //  注释代码为feign接口实现测试代码  helloServiceFallback为feign接口（UserFeignClient）实现类

    //注入feign接口实现类
    @Autowired
    private HelloServiceFallback helloServiceFallback;

    //注入feign接口
    @Autowired
    private UserFeignClient userFeignClient;



    @RequestMapping("/user")
    public String helloConsumer(){

        //用feign接口实现类来进行服务降级
     /*   StringBuilder sb=new StringBuilder();
        sb.append(helloServiceFallback.hello()).append("<p>");
        sb.append(helloServiceFallback.hello("hhaa")).append("<p>");
        sb.append(helloServiceFallback.hello((long) 12,"rose")).append("<p>");
        sb.append(helloServiceFallback.hello(new User(11,"alice")));
        return sb.toString();*/

       //用feign接口来进行服务降级
/*
        StringBuilder sb=new StringBuilder();
        sb.append(userFeignClient.hello()).append("<p>");
        sb.append(userFeignClient.hello("hhaa")).append("<p>");
        sb.append(userFeignClient.hello((long) 12,"rose")).append("<p>");
        sb.append(userFeignClient.hello(new User(11,"alice"))).append("\n");
        return sb.toString();
*/


      //单次访问降级
        //  feign接口
        return userFeignClient.hello();
        //用feign接口实现类
         // return this.helloServiceFallback.hello();
    }


}
