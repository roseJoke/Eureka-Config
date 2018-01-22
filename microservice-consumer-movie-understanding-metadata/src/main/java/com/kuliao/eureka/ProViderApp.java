package com.kuliao.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication
@EnableEurekaClient
public class ProViderApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(ProViderApp.class);
    }
}
