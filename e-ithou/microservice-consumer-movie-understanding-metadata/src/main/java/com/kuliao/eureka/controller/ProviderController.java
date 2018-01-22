package com.kuliao.eureka.controller;

import com.kuliao.eureka.entity.User;


import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/user{id}")
    @ResponseBody
    public User findById(@PathVariable Long id){
       return this.restTemplate.getForObject("http://localhost:8555/"+id,User.class);
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("microservice-provider-user");  //获取对应服务的配置信息
        /*List<ServiceInstance> list = discoveryClient.getInstances(" ");
        if (list != null && list.size() > 0 ) {
            return list.get().getUri();
        }
        return null;*/

    }


}
