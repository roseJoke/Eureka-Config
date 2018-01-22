package com.kuliao.eurek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient                      //激活Eurka中的自动化配置
@EnableFeignClients
//@RibbonClient(name = "eureka-provider", configuration = RibbonConfig.class)
public class ConsumerApp {
   /* @Bean
    @LoadBalanced
        //开启客户端负载均衡
    RestTemplate restTemplate() {             // restTemplate是spring的Bean实例
        return new RestTemplate();
    }*/

  /*  @Bean
    Logger.Level feignLoggerLevel(){          //实现日志配置  当然也可以用配置类实现
       return Logger.Level.FULL;
    }*/
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }
}
