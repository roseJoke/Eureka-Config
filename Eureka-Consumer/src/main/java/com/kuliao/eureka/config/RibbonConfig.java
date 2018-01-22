package com.kuliao.eureka.config;

import com.netflix.client.IClient;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {
     public IRule ribbonRule(IClientConfig config){
         return new RandomRule();
     }
}
