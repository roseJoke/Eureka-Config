package com.kuliao.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ControllerService {
    @Autowired
    RestTemplate restTemplate;           //负载均衡条件 1

    public String getName(){
        return restTemplate.getForObject("http://eureka-provider/getName",String.class);
    }
}
