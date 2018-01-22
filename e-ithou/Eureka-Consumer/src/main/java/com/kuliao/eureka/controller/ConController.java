package com.kuliao.eureka.controller;

import com.kuliao.eureka.service.ControllerService;
import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConController {

    private static final Logger LOGGER= LoggerFactory.getLogger(ConController.class);

    @Autowired
    ControllerService controllerService;

    @Autowired
    LoadBalancerClient loadBalancerClient;              //负载均衡条2


    @RequestMapping("/getName")
    public String getProviderName(){
      return controllerService.getName();
    }


    public String loadbalance(){
        ServiceInstance serviceInstance2=loadBalancerClient.choose("eureka-provider");

        LOGGER.info(serviceInstance2.getServiceId()+"："+serviceInstance2.getPort()+"\n");
        return "loadbalance";
    }
}
