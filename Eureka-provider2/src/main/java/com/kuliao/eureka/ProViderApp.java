package com.kuliao.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
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
        for(int i=0;i<3;i++){
            SpringApplication app=new SpringApplication(ProViderApp.class);
         app.run(ProViderApp.class);
    }
 }
}
