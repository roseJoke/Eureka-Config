package com.kuliao.eureka;

import com.kuliao.eureka.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */

@EnableCircuitBreaker                       //开启断路器功能
@SpringBootApplication
@EnableDiscoveryClient                      //激活Eurka中的自动化配置
@RibbonClient(name = "eureka-provider", configuration = RibbonConfig.class)
public class ConsumerApp {
    @Bean
    @LoadBalanced
        //开启客户端负载均衡

    RestTemplate restTemplate() {             // restTemplate是spring的Bean实例
        return new RestTemplate();
    }


    public static void main(String[] args) {

      /*  for(int i=0;i<3;i++){
            for(int j=8088;j<8090;j++){
                port=j;
            }

            SpringApplication app=new SpringApplication(ConsumerApp.class);
            app.*/
        SpringApplication.run(ConsumerApp.class, args);
/*  }*/

    }
}
