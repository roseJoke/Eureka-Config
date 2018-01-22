package com.kuliao.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class AZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(AZuulApplication.class, args);
	}
}
