package com.kuliao.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer      //启动一个服务注册中心，提供给其他应用进行对话
public class UrkApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(UrkApp.class);
    }
}
